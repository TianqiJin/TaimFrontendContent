package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservicemodel.CreateProductDTO;
import com.taim.taimwebcontent.model.CreateProductInput;
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
