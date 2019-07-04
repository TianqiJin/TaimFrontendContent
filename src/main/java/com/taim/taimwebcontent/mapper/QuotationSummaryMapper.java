package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservicemodel.QuotationDTO;
import com.taim.taimwebcontent.model.quotationdetail.QuotationSummary;
import org.springframework.stereotype.Component;

@Component
public class QuotationSummaryMapper {

    public QuotationSummary map(QuotationDTO quotationDTO) {
        return QuotationSummary.builder()
                .quotationDate(quotationDTO.getQuotationDate())
                .dueDate(quotationDTO.getDueDate())
                .note(quotationDTO.getNote())
                .quotationId(quotationDTO.getQuotationId())
                .status(quotationDTO.getStatus())
                .billFromAddress(quotationDTO.getBillFromAddress())
                .billToAddress(quotationDTO.getBillToAddress())
                .build();
    }
}
