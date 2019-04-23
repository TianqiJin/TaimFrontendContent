package com.taim.content.model;

import com.taim.content.model.quotationdetail.QuotationDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateQuotationInput {
    private QuotationDetail quotationDetail;
}
