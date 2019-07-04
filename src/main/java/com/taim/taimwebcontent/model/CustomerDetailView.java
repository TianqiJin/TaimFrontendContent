package com.taim.taimwebcontent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailView {
    private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private BigDecimal storeCredit;
    private String customerClass;
    private String userType;
    private String pstNumber;
    private List<AddressDetailView> addressDetailViews;
    private List<QuotationOverviewView> quotationOverviewViews;
}
