package com.taim.content.mapper;

import com.google.common.base.Converter;
import com.taim.content.model.VendorOverviewView;
import com.taim.taimbackendservicemodel.VendorDTO;
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
