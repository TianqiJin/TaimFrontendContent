package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservice.model.Staff;
import com.taim.taimwebcontent.model.StaffOverviewView;

public interface StaffOverviewMapper {
    StaffOverviewView map(Staff staff);
}
