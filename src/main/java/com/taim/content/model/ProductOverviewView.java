package com.taim.content.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOverviewView {
    private long id;
    private BigDecimal unitPrice;
    private String sku;
    private String displayName;
    private String texture;
    private String color;
    private BigDecimal totalNum;
    private BigDecimal totalNumVirtual;
}
