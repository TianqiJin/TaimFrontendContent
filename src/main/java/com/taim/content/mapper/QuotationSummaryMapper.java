package com.taim.content.mapper;

import com.google.common.base.Converter;
import com.taim.content.model.quotationdetail.QuotationSummary;
import com.taim.taimbackendservicemodel.QuotationDTO;
import org.springframework.stereotype.Component;

@Component
public class QuotationSummaryMapper {

    public QuotationSummary map(QuotationDTO quotationDTO) {
        return QuotationSummary.builder()
                .createDate(quotationDTO.getCreatedDate())
                .dueDate(quotationDTO.getDueDate())
                .note(quotationDTO.getNote())
                .quotationId(quotationDTO.getQuotationId())
                .status(quotationDTO.getStatus())
                .build();
    }
}
