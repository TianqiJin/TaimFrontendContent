package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservicemodel.CreateVendorDTO;
import com.taim.taimwebcontent.model.CreateVendorInput;
import org.springframework.stereotype.Component;

@Component
public class CreateVendorInputMapper {

    public CreateVendorDTO map(CreateVendorInput createVendorInput) {
        return CreateVendorDTO.builder()
                .gstNumber(createVendorInput.getGstNumber())
                .userType(createVendorInput.getUserType())
                .email(createVendorInput.getEmail())
                .firstName(createVendorInput.getFirstName())
                .lastName(createVendorInput.getLastName())
                .phone(createVendorInput.getPhone())
                .build();
    }

}
