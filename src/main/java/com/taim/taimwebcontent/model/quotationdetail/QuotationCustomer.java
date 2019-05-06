package com.taim.taimwebcontent.model.quotationdetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuotationCustomer {
    private String firstName;
    private String lastName;
    private String customerType;
    private String customerClass;
    private String email;
    private String phone;
    private long id;
}
