package com.taim.content.mapper;

import com.google.common.base.Converter;
import com.taim.taimbackendservice.model.Product;
import com.taim.content.model.CreateProductInput;
import com.taim.taimbackendservicemodel.CreateProductDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateProductInputMapper{

    public CreateProductDTO map(CreateProductInput createProductInput) {
        return CreateProductDTO.builder()
                .sku(createProductInput.getSku())
                .color(createProductInput.getColor())
                .displayName(createProductInput.getDisplayName())
                .height(createProductInput.getHeight())
                .width(createProductInput.getWidth())
                .length(createProductInput.getLength())
                .piecePerBox(createProductInput.getPiecesPerBox())
                .totalNum(createProductInput.getTotalNumber())
                .totalNumVirtual(createProductInput.getTotalVirtualNumber())
                .texture(createProductInput.getTexture())
                .unitPrice(createProductInput.getUnitPrice())
                .build();
    }
}
