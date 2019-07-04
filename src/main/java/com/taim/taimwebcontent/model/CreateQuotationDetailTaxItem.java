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
public class CreateQuotationDetailTaxItem {
    private String taxType;
    private BigDecimal taxRate;
}