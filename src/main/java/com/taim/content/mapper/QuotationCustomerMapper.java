package com.taim.content.mapper;

import com.google.common.base.Converter;
import com.taim.content.model.quotationdetail.QuotationCustomer;
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
