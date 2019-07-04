package com.taim.taimwebcontent.model.quotationdetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuotationDetail {
    private QuotationCustomer quotationCustomer;
    private QuotationSummary quotationSummary;
    private List<QuotationItem> quotationItems;
    private Map<String, List<BigDecimal>> allowedTaxRateMap;
    private boolean submitted;
}
