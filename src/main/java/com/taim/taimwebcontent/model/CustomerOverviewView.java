package com.taim.taimwebcontent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOverviewView {
    private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String userClass;
    private String userType;
}
