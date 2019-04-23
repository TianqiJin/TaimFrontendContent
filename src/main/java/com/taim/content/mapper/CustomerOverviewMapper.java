package com.taim.content.mapper;

import com.google.common.base.Converter;
import com.taim.content.model.CustomerOverviewView;
import com.taim.taimbackendservicemodel.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerOverviewMapper {

    public CustomerOverviewView map(CustomerDTO customerDTO) {
        return CustomerOverviewView.builder()
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .email(customerDTO.getEmail())
                .phone(customerDTO.getPhone())
                .userClass(customerDTO.getCustomerClass().getCustomerClassName())
                .userType(customerDTO.getUserType())
                .id(customerDTO.getId())
                .build();
    }
}
