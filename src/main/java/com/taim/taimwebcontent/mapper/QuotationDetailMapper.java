package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservicemodel.QuotationDTO;
import com.taim.taimwebcontent.model.quotationdetail.QuotationDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class QuotationDetailMapper {

    private final QuotationCustomerMapper quotationCustomerMapper;
    private final QuotationSummaryMapper quotationSummaryMapper;
    private final QuotationItemMapper quotationItemMapper;

    @Autowired
    public QuotationDetailMapper(QuotationCustomerMapper quotationCustomerMapper,
                                 QuotationSummaryMapper quotationSummaryMapper,
                                 QuotationItemMapper quotationItemMapper) {
        this.quotationCustomerMapper = quotationCustomerMapper;
        this.quotationSummaryMapper = quotationSummaryMapper;
        this.quotationItemMapper = quotationItemMapper;
    }

    public QuotationDetail map(QuotationDTO quotationDTO) {
        return QuotationDetail.builder()
                .quotationCustomer(this.quotationCustomerMapper.map(quotationDTO.getCustomer()))
                .quotationSummary(this.quotationSummaryMapper.map(quotationDTO))
                .quotationItems(quotationDTO.getTransactionDetails().stream()
                        .map(this.quotationItemMapper::map)
                        .collect(Collectors.toList()))
                .build();
    }
}
