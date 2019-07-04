package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservicemodel.ProductDTO;
import com.taim.taimwebcontent.model.ProductDetailView;
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
