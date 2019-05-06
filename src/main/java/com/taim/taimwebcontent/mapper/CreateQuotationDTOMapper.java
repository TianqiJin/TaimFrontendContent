package com.taim.taimwebcontent.mapper;

import com.taim.taimwebcontent.model.CreateQuotationInput;
import com.taim.taimbackendservicemodel.CreateQuotationDTO;
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
                .customerId(createQuotationInput.getCustomerId())
                .status(createQuotationInput.getStatus())
                .note(createQuotationInput.getNote())
                .dueDate(createQuotationInput.getDueDate())
                .quotationDate(createQuotationInput.getQuotationDate())
                .quotationId(createQuotationInput.getQuotationId())
                .createQuotationDetailDTOList(createQuotationInput.getCreateQuotationDetailItems().stream()
                        .map(this.createQuotationDetailDTOMapper::map)
                        .collect(Collectors.toList()))
                .build();
    }
}
