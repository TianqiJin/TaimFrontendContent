package com.taim.taimwebcontent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateVendorInput {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String userType;
    private String gstNumber;
}
