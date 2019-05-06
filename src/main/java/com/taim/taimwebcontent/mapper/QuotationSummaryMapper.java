package com.taim.taimwebcontent.mapper;

import com.taim.taimwebcontent.model.quotationdetail.QuotationSummary;
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
