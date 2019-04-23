package com.taim.content.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendorOverviewView {
    private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String userType;
}
