package com.taim.taimwebcontent.manager;

import com.google.gson.Gson;
import com.taim.taimbackendservicejavaclient.client.CustomerClient;
import com.taim.taimbackendservicejavaclient.client.ProductClient;
import com.taim.taimbackendservicejavaclient.client.TransactionClient;
import com.taim.taimbackendservicemodel.CreateQuotationDTO;
import com.taim.taimbackendservicemodel.QuotationDTO;
import com.taim.taimbackendservicemodel.TransactionStatusDTO;
import com.taim.taimwebcontent.mapper.CreateQuotationDTOMapper;
import com.taim.taimwebcontent.mapper.QuotationDetailMapper;
import com.taim.taimwebcontent.mapper.QuotationOverviewViewMapper;
import com.taim.taimwebcontent.model.CreateQuotationInput;
import com.taim.taimwebcontent.model.QuotationOverviewView;
import com.taim.taimwebcontent.model.quotationdetail.QuotationCustomer;
import com.taim.taimwebcontent.model.quotationdetail.QuotationDetail;
import com.taim.taimwebcontent.model.quotationdetail.QuotationSummary;
import com.taim.taimwebcontent.utils.TransactionHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TransactionManagerImpl implements TransactionManager {

    private final Gson gson = new Gson();
    private final TransactionClient transactionClient;
    private final TransactionHelper transactionHelper;
    private final CreateQuotationDTOMapper createQuotationDTOMapper;
    private final QuotationOverviewViewMapper quotationOverviewViewMapper;
    private final QuotationDetailMapper quotationDetailMapper;

    @Autowired
    public TransactionManagerImpl(TransactionClient transactionClient,
                                  TransactionHelper transactionHelper,
                                  CreateQuotationDTOMapper createQuotationDTOMapper,
                                  QuotationOverviewViewMapper quotationOverviewViewMapper,
                                  QuotationDetailMapper quotationDetailMapper) {
        this.transactionClient = transactionClient;
        this.transactionHelper = transactionHelper;
        this.createQuotationDTOMapper = createQuotationDTOMapper;
        this.quotationOverviewViewMapper = quotationOverviewViewMapper;
        this.quotationDetailMapper = quotationDetailMapper;
    }

    @Override
    public QuotationDetail initNewQuotation() {

        QuotationDetail quotationDetail = new QuotationDetail();
        quotationDetail.setQuotationCustomer(new QuotationCustomer());
        quotationDetail.setQuotationSummary(new QuotationSummary());
        quotationDetail.setQuotationItems(new ArrayList<>());
        quotationDetail.getQuotationSummary().setQuotationDate(new Date());
        quotationDetail.getQuotationSummary().setDueDate(new Date());
        quotationDetail.getQuotationSummary().setStatus(TransactionStatusDTO.CREATED_NOT_SUBMITTED.getValue());
        quotationDetail.getQuotationSummary().setQuotationId(transactionHelper.generateRandomString("Q-",
                TransactionHelper.QUOTATION_ID_COUNT, null));
        quotationDetail.setAllowedTaxRateMap(transactionClient.getAllowedTaxRates());

        return quotationDetail;
    }

    @Override
    public void createNewQuotation(CreateQuotationInput createQuotationInput) {
        log.info("Save and submitting quotation - {}", gson.toJson(createQuotationInput));
        CreateQuotationDTO createQuotationDTO = this.createQuotationDTOMapper.map(createQuotationInput);
        transactionClient.saveQuotation(createQuotationDTO);
    }

    @Override
    public List<QuotationOverviewView> getQuotationOverviewViewByCustomerId(Long customerId) {
        List<QuotationDTO> quotationDTOList = this.transactionClient.getQuotationListByCustomerId(customerId);

        return quotationDTOList.stream().map(this.quotationOverviewViewMapper::map).collect(Collectors.toList());
    }

    @Override
    public List<QuotationOverviewView> getAllQuotationOverviewViews() {
        List<QuotationDTO> quotationDTOList = this.transactionClient.getAllQuotations();

        return quotationDTOList.stream().map(this.quotationOverviewViewMapper::map).collect(Collectors.toList());
    }

    @Override
    public QuotationDetail getQuotationDetailByQuotationId(String quotationId) {
        QuotationDTO quotationDTO = this.transactionClient.getQuotationByQuotationId(quotationId);
        QuotationDetail quotationDetail = this.quotationDetailMapper.map(quotationDTO);
        quotationDetail.setAllowedTaxRateMap(this.transactionClient.getAllowedTaxRates());
        if (quotationDTO.getStatus().equals(TransactionStatusDTO.SUBMITTED.getValue())) {
            quotationDetail.setSubmitted(true);
        }

        return quotationDetail;
    }
}
