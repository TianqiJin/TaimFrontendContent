package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservicemodel.QuotationDTO;
import com.taim.taimwebcontent.model.QuotationOverviewView;
import org.springframework.stereotype.Component;

@Component
public class QuotationOverviewViewMapper {

    public QuotationOverviewView map(QuotationDTO quotationDTO) {
        return QuotationOverviewView.builder()
                .dueDate(quotationDTO.getDueDate())
                .quotationDate(quotationDTO.getQuotationDate())
                .quotationId(quotationDTO.getQuotationId())
                .status(quotationDTO.getStatus())
                .total(quotationDTO.getTotal())
                .taxTotal(quotationDTO.getTotalTax())
                .build();
    }
}
