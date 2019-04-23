package com.taim.content.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailView {
    private long id;
    private String sku;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private String displayName;
    private String texture;
    private BigDecimal totalNum;
    private BigDecimal totalNumVirtual;
    private BigDecimal unitPrice;
    private BigDecimal piecePerBox;
}
