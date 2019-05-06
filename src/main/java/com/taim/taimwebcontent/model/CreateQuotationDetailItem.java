package com.taim.taimwebcontent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateQuotationDetailItem {
    private String sku;
    private BigDecimal unitPrice;
    private BigDecimal quantity;
    private BigDecimal discount;
    private String note;
}
