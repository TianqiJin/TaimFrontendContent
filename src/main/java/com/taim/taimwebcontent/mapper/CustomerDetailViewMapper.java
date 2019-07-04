package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservicemodel.CustomerDTO;
import com.taim.taimbackendservicemodel.QuotationDTO;
import com.taim.taimwebcontent.model.CustomerDetailView;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerDetailViewMapper {

    private final AddressDetailViewMapper addressDetailViewMapper;

    public CustomerDetailViewMapper(AddressDetailViewMapper addressDetailViewMapper) {
        this.addressDetailViewMapper = addressDetailViewMapper;
    }

    public CustomerDetailView map(CustomerDTO customerDTO) {
        return CustomerDetailView.builder()
                .id(customerDTO.getId())
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .phone(customerDTO.getPhone())
                .email(customerDTO.getEmail())
                .storeCredit(customerDTO.getStoreCredit())
                .customerClass(customerDTO.getCustomerClass().getCustomerClassName())
                .userType(customerDTO.getUserType())
                .pstNumber(customerDTO.getPstNumber())
                .addressDetailViews(customerDTO.getAddresses().stream()
                        .map(this.addressDetailViewMapper::map)
                        .collect(Collectors.toList()))
                .build();
    }
}
