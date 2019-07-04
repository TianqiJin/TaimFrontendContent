package com.taim.taimwebcontent.controller;

import com.taim.taimbackendservicejavaclient.client.CustomerClassClient;
import com.taim.taimwebcontent.mapper.CustomerClassViewMapper;
import com.taim.taimwebcontent.model.CustomerClassView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerClassResourceController {

    private final CustomerClassViewMapper customerClassViewMapper;
    private final CustomerClassClient customerClassClient;

    @Autowired
    public CustomerClassResourceController(CustomerClassViewMapper customerClassViewMapper,
                                           CustomerClassClient customerClassClient) {
        this.customerClassViewMapper = customerClassViewMapper;
        this.customerClassClient = customerClassClient;
    }

    @GetMapping(
            value = "/customerclasses",
            params = "action=getAll"
    )
    public List<CustomerClassView> getAllCustomerClasses() {
        return customerClassClient.getAllCustomerClasses().stream()
                .map(customerClassViewMapper::map)
                .collect(Collectors.toList());
    }
}
