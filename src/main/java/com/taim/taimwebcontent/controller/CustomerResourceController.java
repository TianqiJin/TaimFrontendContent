package com.taim.taimwebcontent.controller;

import com.taim.taimwebcontent.mapper.CreateCustomerInputMapper;
import com.taim.taimwebcontent.mapper.CustomerOverviewMapper;
import com.taim.taimwebcontent.model.CreateCustomerInput;
import com.taim.taimwebcontent.model.CustomerOverviewView;
import com.taim.taimbackendservicejavaclient.client.CustomerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerResourceController {

    private final CustomerClient customerClient;
    private final CustomerOverviewMapper customerOverviewViewMapper;
    private final CreateCustomerInputMapper createCustomerInputMapper;

    @Autowired
    public CustomerResourceController(
            CustomerClient customerClient,
            CustomerOverviewMapper customerOverviewViewMapper,
            CreateCustomerInputMapper createCustomerInputMapper) {
        this.customerClient = customerClient;
        this.customerOverviewViewMapper = customerOverviewViewMapper;
        this.createCustomerInputMapper = createCustomerInputMapper;
    }

    @GetMapping(
            value = "/customers",
            params = "action=getAll"
    )
    public List<CustomerOverviewView> getAllCustomerList() {
        return this.customerClient.getAllCustomers().stream()
                .map(customerOverviewViewMapper::map)
                .collect(Collectors.toList());
    }

    @PostMapping(
            value = "/customers",
            params = "action=new"
    )
    public CustomerOverviewView createNewCustomer(@RequestBody CreateCustomerInput createCustomerInput) {
        this.customerClient.saveCustomer(this.createCustomerInputMapper.map(createCustomerInput));

        return null;
    }

}
