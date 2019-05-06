package com.taim.taimwebcontent.mapper;

import com.taim.taimwebcontent.model.ProductOverviewView;
import com.taim.taimbackendservicemodel.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductOverviewViewMapper {

    public ProductOverviewView map(ProductDTO productDTO) {
        return ProductOverviewView.builder()
                .displayName(productDTO.getDisplayName())
                .sku(productDTO.getSku())
                .texture(productDTO.getTexture())
                .color(productDTO.getColor())
                .totalNum(productDTO.getTotalNum())
                .totalNumVirtual(productDTO.getTotalNumVirtual())
                .id(productDTO.getId())
                .unitPrice(productDTO.getUnitPrice())
                .build();
    }
}
