package com.taim.taimwebcontent.controller;

import com.google.common.collect.ImmutableList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
