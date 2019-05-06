package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservice.model.Staff;
import com.taim.taimwebcontent.model.StaffOverviewView;
import org.springframework.stereotype.Component;

@Component
public class StaffOverviewMapperImpl implements StaffOverviewMapper {

    @Override
    public StaffOverviewView map(Staff staff) {
        return StaffOverviewView.builder()
                .firstName(staff.getFirstName())
                .lastName(staff.getLastName())
                .email(staff.getEmail())
                .phone(staff.getPhone())
                .position(staff.getPosition().getValue())
                .id(staff.getId())
                .build();
    }
}
