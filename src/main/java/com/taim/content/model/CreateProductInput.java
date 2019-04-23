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
public class CreateProductInput {
    private String sku;
    private String displayName;
    private String texture;
    private String color;
    private BigDecimal totalNumber;
    private BigDecimal totalVirtualNumber;
    private BigDecimal unitPrice;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal piecesPerBox;
}
