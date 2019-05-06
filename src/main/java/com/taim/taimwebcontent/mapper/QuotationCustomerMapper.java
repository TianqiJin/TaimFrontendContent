package com.taim.taimwebcontent.mapper;

import com.taim.taimwebcontent.model.quotationdetail.QuotationCustomer;
import com.taim.taimbackendservicemodel.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class QuotationCustomerMapper {

    public QuotationCustomer map(CustomerDTO customerDTO) {
        return QuotationCustomer.builder()
                .customerClass(customerDTO.getCustomerClass().getCustomerClassName())
                .customerType(customerDTO.getUserType())
                .email(customerDTO.getEmail())
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .phone(customerDTO.getPhone())
                .id(customerDTO.getId())
                .build();
    }
}
