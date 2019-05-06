package com.taim.taimwebcontent.mapper;

import com.taim.taimwebcontent.model.CreateQuotationDetailItem;
import com.taim.taimwebcontent.model.quotationdetail.QuotationItem;
import com.taim.taimbackendservicemodel.CreateQuotationDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateQuotationDetailDTOMapper {

    public CreateQuotationDetailDTO map(CreateQuotationDetailItem createQuotationDetailItem) {
        return CreateQuotationDetailDTO.builder()
                .discount(createQuotationDetailItem.getDiscount())
                .productSku(createQuotationDetailItem.getSku())
                .note(createQuotationDetailItem.getNote())
                .unitPrice(createQuotationDetailItem.getUnitPrice())
                .quantity(createQuotationDetailItem.getQuantity())
                .build();
    }
}
