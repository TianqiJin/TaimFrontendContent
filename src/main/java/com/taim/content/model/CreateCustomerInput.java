package com.taim.content.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCustomerInput {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String pst;
    private BigDecimal storeCredit;
    private String customerClass;
    private String userType;
}
