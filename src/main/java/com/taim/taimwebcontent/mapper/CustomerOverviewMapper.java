package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservicemodel.CustomerDTO;
import com.taim.taimwebcontent.model.CustomerOverviewView;
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
