package com.taim.taimwebcontent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuotationOverviewView {
    private String quotationId;
    private Date quotationDate;
    private Date dueDate;
    private String status;
    private BigDecimal total;
    private BigDecimal taxTotal;
}
