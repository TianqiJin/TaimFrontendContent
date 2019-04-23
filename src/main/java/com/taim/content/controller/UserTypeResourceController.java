package com.taim.content.controller;

import com.google.common.collect.ImmutableList;
import com.taim.taimbackendservice.model.basemodels.UserBaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserTypeResourceController {

    @GetMapping(
            value = "/usertypes",
            params = "action=getAll"
    )
    public List<String> getAllUserTypes() {
        return ImmutableList.of("Individual", "Company");
    }

}
