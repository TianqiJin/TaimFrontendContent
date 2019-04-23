package com.taim.content.mapper;

import com.google.common.base.Converter;
import com.taim.content.model.CreateCustomerInput;
import com.taim.taimbackendservicemodel.CreateCustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerInputMapper {

    public CreateCustomerDTO map(CreateCustomerInput createCustomerInput) {
        return CreateCustomerDTO.builder()
                .pstNumber(createCustomerInput.getPst())
                .storeCredit(createCustomerInput.getStoreCredit())
                .userType(createCustomerInput.getUserType())
                .email(createCustomerInput.getEmail())
                .firstName(createCustomerInput.getFirstName())
                .lastName(createCustomerInput.getLastName())
                .phone(createCustomerInput.getPhone())
                .customerClassName(createCustomerInput.getCustomerClass())
                .build();
    }

}
