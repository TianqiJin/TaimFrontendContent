package com.taim.taimwebcontent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateQuotationInput {
    private String quotationId;
    private long customerId;
    private long staffId;
    private List<CreateQuotationDetailItem> createQuotationDetailItems;
    private String note;
    private String status;
    private Date quotationDate;
    private Date dueDate;
    private String billFromAddress;
    private String billToAddress;
    private boolean submit;
}
