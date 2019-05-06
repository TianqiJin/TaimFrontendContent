package com.taim.taimwebcontent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaxInfo {
    private BigDecimal taxRate;
    private String taxType;
    private BigDecimal taxAmount;
    private BigDecimal taxAmountByOne;
}
