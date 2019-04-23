package com.taim.content.mapper;

import com.google.common.base.Converter;
import com.taim.taimbackendservice.model.CustomerClass;
import com.taim.content.model.CustomerClassView;
import com.taim.taimbackendservicemodel.CustomerClassDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerClassViewMapper {

    public CustomerClassView map(CustomerClassDTO customerClassDTO) {
        return CustomerClassView.builder()
                .id(customerClassDTO.getId())
                .customerClassName(customerClassDTO.getCustomerClassName())
                .customerDiscount(customerClassDTO.getCustomerDiscount())
                .description(customerClassDTO.getDescription()).build();
    }
}
