package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservicemodel.CreateQuotationDetailTaxItemDTO;
import com.taim.taimwebcontent.model.CreateQuotationDetailTaxItem;
import org.springframework.stereotype.Component;

@Component
public class CreateQuotationDetailTaxItemDTOMapper {

    public CreateQuotationDetailTaxItemDTO map(CreateQuotationDetailTaxItem createQuotationDetailTaxItem) {
        return CreateQuotationDetailTaxItemDTO.builder()
                .taxRate(createQuotationDetailTaxItem.getTaxRate())
                .taxType(createQuotationDetailTaxItem.getTaxType())
                .build();

    }
}
