package com.taim.content.mapper;

import com.google.common.base.Converter;
import com.taim.content.model.CreateQuotationInput;
import com.taim.content.model.quotationdetail.QuotationItem;
import com.taim.taimbackendservicemodel.CreateQuotationDTO;
import com.taim.taimbackendservicemodel.CreateQuotationDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CreateQuotationDTOMapper {

    private final CreateQuotationDetailDTOMapper createQuotationDetailDTOMapper;

    @Autowired
    public CreateQuotationDTOMapper(CreateQuotationDetailDTOMapper createQuotationDetailDTOMapper) {
        this.createQuotationDetailDTOMapper = createQuotationDetailDTOMapper;
    }

    public CreateQuotationDTO map(CreateQuotationInput createQuotationInput) {
        return CreateQuotationDTO.builder()
                .customerId(createQuotationInput.getQuotationDetail().getQuotationCustomer().getId())
                .status(createQuotationInput.getQuotationDetail().getQuotationSummary().getStatus())
                .note(createQuotationInput.getQuotationDetail().getQuotationSummary().getNote())
                .createQuotationDetailDTOList(createQuotationInput.getQuotationDetail().getQuotationItems().stream()
                        .map(this.createQuotationDetailDTOMapper::map)
                        .collect(Collectors.toList()))
                .build();
    }
}
