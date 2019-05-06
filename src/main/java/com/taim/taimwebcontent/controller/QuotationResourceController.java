package com.taim.taimwebcontent.controller;

import com.taim.taimbackendservicejavaclient.client.QuotationClient;
import com.taim.taimbackendservicemodel.CreateQuotationDTO;
import com.taim.taimbackendservicemodel.TransactionStatusDTO;
import com.taim.taimwebcontent.mapper.CreateQuotationDTOMapper;
import com.taim.taimwebcontent.model.CreateQuotationInput;
import com.taim.taimwebcontent.model.quotationdetail.QuotationCustomer;
import com.taim.taimwebcontent.model.quotationdetail.QuotationDetail;
import com.taim.taimwebcontent.model.quotationdetail.QuotationSummary;
import com.taim.taimwebcontent.utils.TransactionIDUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class QuotationResourceController {

    private final TransactionIDUtils transactionIDUtils;
    private final CreateQuotationDTOMapper createQuotationDTOMapper;
    private final QuotationClient quotationClient;


    @Autowired
    public QuotationResourceController(TransactionIDUtils transactionIDUtils,
                                       CreateQuotationDTOMapper createQuotationDTOMapper, QuotationClient quotationClient) {
        this.transactionIDUtils = transactionIDUtils;
        this.createQuotationDTOMapper = createQuotationDTOMapper;
        this.quotationClient = quotationClient;
    }

    @GetMapping(
            value = "/quotations",
            params = "action=init"
    )
    public QuotationDetail initNewQuotation() {
        QuotationDetail quotationDetail = new QuotationDetail();
        quotationDetail.setQuotationCustomer(new QuotationCustomer());
        quotationDetail.setQuotationSummary(new QuotationSummary());
        quotationDetail.setQuotationItems(new ArrayList<>());
        quotationDetail.getQuotationSummary().setQuotationDate(new Date());
        quotationDetail.getQuotationSummary().setStatus(TransactionStatusDTO.CREATED_NOT_SUBMITTED.getValue());

        quotationDetail.getQuotationSummary().setQuotationId(transactionIDUtils.generateRandomString("Q",
                TransactionIDUtils.QUOTATION_ID_COUNT, null));

        return quotationDetail;
    }

    @PostMapping(
            value = "/quotations",
            params = "action=save"
    )
    public void saveQuotation(@RequestBody CreateQuotationInput createQuotationInput) {
        CreateQuotationDTO createQuotationDTO = this.createQuotationDTOMapper.map(createQuotationInput);
        quotationClient.saveQuotation(createQuotationDTO);
    }
}
