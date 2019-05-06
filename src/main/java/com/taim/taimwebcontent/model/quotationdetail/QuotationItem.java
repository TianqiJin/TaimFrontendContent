package com.taim.taimwebcontent.model.quotationdetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuotationItem {
    private String sku;
    private String displayName;
    private BigDecimal unitPrice;
    private BigDecimal quantity;
    private BigDecimal discount;
    private BigDecimal subtotal;
    private String note;
}
