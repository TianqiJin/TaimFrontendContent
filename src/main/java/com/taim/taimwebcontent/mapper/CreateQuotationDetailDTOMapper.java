package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservicemodel.CreateQuotationDetailDTO;
import com.taim.taimwebcontent.model.CreateQuotationDetailItem;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CreateQuotationDetailDTOMapper {

    private final CreateQuotationDetailTaxItemDTOMapper createQuotationDetailTaxItemDTOMapper;

    public CreateQuotationDetailDTOMapper(CreateQuotationDetailTaxItemDTOMapper createQuotationDetailTaxItemDTOMapper) {
        this.createQuotationDetailTaxItemDTOMapper = createQuotationDetailTaxItemDTOMapper;
    }

    public CreateQuotationDetailDTO map(CreateQuotationDetailItem createQuotationDetailItem) {
        return CreateQuotationDetailDTO.builder()
                .discount(createQuotationDetailItem.getDiscount())
                .productSku(createQuotationDetailItem.getSku())
                .note(createQuotationDetailItem.getNote())
                .unitPrice(createQuotationDetailItem.getUnitPrice())
                .quantity(createQuotationDetailItem.getQuantity())
                .createQuotationDetailTaxItemDTOList(createQuotationDetailItem.getCreateQuotationDetailTaxItems()
                        .stream()
                        .map(this.createQuotationDetailTaxItemDTOMapper:: map)
                        .collect(Collectors.toList()))
                .build();
    }
}
