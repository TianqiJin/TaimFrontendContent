package com.taim.taimwebcontent.mapper;

import com.taim.taimwebcontent.model.CustomerClassView;
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
