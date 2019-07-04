package com.taim.taimwebcontent.controller;

import com.taim.taimbackendservicejavaclient.client.CustomerClient;
import com.taim.taimbackendservicejavaclient.client.TransactionClient;
import com.taim.taimbackendservicemodel.CustomerDTO;
import com.taim.taimbackendservicemodel.QuotationDTO;
import com.taim.taimwebcontent.mapper.CreateCustomerInputMapper;
import com.taim.taimwebcontent.mapper.CustomerDetailViewMapper;
import com.taim.taimwebcontent.mapper.CustomerOverviewMapper;
import com.taim.taimwebcontent.model.CreateCustomerInput;
import com.taim.taimwebcontent.model.CustomerDetailView;
import com.taim.taimwebcontent.model.CustomerOverviewView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerResourceController {

    private final CustomerClient customerClient;
    private final CustomerOverviewMapper customerOverviewViewMapper;
    private final CreateCustomerInputMapper createCustomerInputMapper;
    private final CustomerDetailViewMapper customerDetailViewMapper;

    @Autowired
    public CustomerResourceController(
            CustomerClient customerClient,
            CustomerOverviewMapper customerOverviewViewMapper,
            CreateCustomerInputMapper createCustomerInputMapper,
            CustomerDetailViewMapper customerDetailViewMapper) {
        this.customerClient = customerClient;
        this.customerOverviewViewMapper = customerOverviewViewMapper;
        this.createCustomerInputMapper = createCustomerInputMapper;
        this.customerDetailViewMapper = customerDetailViewMapper;
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
    public void createNewCustomer(@RequestBody CreateCustomerInput createCustomerInput) {
        this.customerClient.saveCustomer(this.createCustomerInputMapper.map(createCustomerInput));
    }

    @GetMapping(
            value = "/customers",
            params = "action=getById"
    )
    public CustomerDetailView getCustomerDetailByCustomerId(@RequestParam("id") Long customerId) {
        CustomerDTO customerDTO = this.customerClient.getCustomerByCustomerId(customerId);

        return this.customerDetailViewMapper.map(customerDTO);
    }

}
