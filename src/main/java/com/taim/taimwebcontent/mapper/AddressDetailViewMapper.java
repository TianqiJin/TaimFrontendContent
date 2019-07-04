package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservicemodel.AddressDTO;
import com.taim.taimwebcontent.model.AddressDetailView;
import org.springframework.stereotype.Component;

@Component
public class AddressDetailViewMapper {

    public AddressDetailView map(AddressDTO addressDTO) {
        return AddressDetailView.builder()
                .id(addressDTO.getId())
                .streetNum(addressDTO.getStreetNum())
                .addressLine1(addressDTO.getAddressLine1())
                .addressLine2(addressDTO.getAddressLine2())
                .city(addressDTO.getCity())
                .province(addressDTO.getProvince())
                .country(addressDTO.getCountry())
                .postalCode(addressDTO.getPostalCode())
                .build();
    }
}
