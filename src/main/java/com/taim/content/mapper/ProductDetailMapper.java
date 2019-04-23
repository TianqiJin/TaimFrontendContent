package com.taim.content.mapper;

import com.google.common.base.Converter;
import com.taim.taimbackendservice.model.Product;
import com.taim.content.model.ProductDetailView;
import com.taim.taimbackendservicemodel.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailMapper {

    public ProductDetailView map(ProductDTO productDTO) {
        return ProductDetailView.builder()
                .displayName(productDTO.getDisplayName())
                .sku(productDTO.getSku())
                .texture(productDTO.getTexture())
                .totalNum(productDTO.getTotalNum())
                .totalNumVirtual(productDTO.getTotalNumVirtual())
                .length(productDTO.getLength())
                .height(productDTO.getHeight())
                .width(productDTO.getWidth())
                .unitPrice(productDTO.getUnitPrice())
                .piecePerBox(productDTO.getPiecePerBox())
                .id(productDTO.getId())
                .build();
    }
}
