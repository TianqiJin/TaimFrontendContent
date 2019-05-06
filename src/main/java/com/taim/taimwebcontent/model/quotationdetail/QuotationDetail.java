package com.taim.taimwebcontent.model.quotationdetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuotationDetail {
    private QuotationCustomer quotationCustomer;
    private QuotationSummary quotationSummary;
    private List<QuotationItem> quotationItems;
}
