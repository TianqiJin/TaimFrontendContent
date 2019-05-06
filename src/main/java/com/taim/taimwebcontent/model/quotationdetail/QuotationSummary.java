package com.taim.taimwebcontent.model.quotationdetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuotationSummary {
    private String quotationId;
    private Date quotationDate;
    private Date dueDate;
    private String createdBy;
    private String status;
    private String note;
}
