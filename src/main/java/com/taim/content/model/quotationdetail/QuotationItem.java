package com.taim.content.model.quotationdetail;

import com.taim.content.model.TaxInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

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
