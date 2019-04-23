package com.taim.content.mapper;

import com.taim.taimbackendservice.model.Staff;
import com.taim.content.model.StaffOverviewView;

public interface StaffOverviewMapper {
    StaffOverviewView map(Staff staff);
}
