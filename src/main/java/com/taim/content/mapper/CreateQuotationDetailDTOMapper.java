package com.taim.content.mapper;

import com.google.common.base.Converter;
import com.taim.content.model.quotationdetail.QuotationItem;
import com.taim.taimbackendservicemodel.CreateQuotationDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateQuotationDetailDTOMapper {

    public CreateQuotationDetailDTO map(QuotationItem quotationItem) {
        return CreateQuotationDetailDTO.builder()
                .discount(quotationItem.getDiscount())
                .productSku(quotationItem.getSku())
                .note(quotationItem.getNote())
                .unitPrice(quotationItem.getUnitPrice())
                .quantity(quotationItem.getQuantity())
                .build();
    }
}
