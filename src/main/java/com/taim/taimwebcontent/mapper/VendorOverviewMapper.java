package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservicemodel.VendorDTO;
import com.taim.taimwebcontent.model.VendorOverviewView;
import org.springframework.stereotype.Component;

@Component
public class VendorOverviewMapper {

    public VendorOverviewView map(VendorDTO vendorDTO) {
        return VendorOverviewView.builder()
                .firstName(vendorDTO.getFirstName())
                .lastName(vendorDTO.getLastName())
                .phone(vendorDTO.getPhone())
                .email(vendorDTO.getEmail())
                .userType(vendorDTO.getUserType())
                .id(vendorDTO.getId())
                .build();
    }
}
