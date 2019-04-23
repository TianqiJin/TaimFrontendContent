package com.taim.content.controller;

import com.taim.content.mapper.CreateVendorInputMapper;
import com.taim.content.mapper.VendorOverviewMapper;
import com.taim.content.model.CreateVendorInput;
import com.taim.content.model.VendorOverviewView;
import com.taim.taimbackendservicejavaclient.client.VendorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class VendorResourceController {

    private final VendorClient vendorClient;
    private final VendorOverviewMapper vendorOverviewMapper;
    private final CreateVendorInputMapper createVendorInputMapper;


    @Autowired
    public VendorResourceController(VendorClient vendorClient,
                                    VendorOverviewMapper vendorOverviewMapper,
                                    CreateVendorInputMapper createVendorInputMapper) {
        this.vendorClient = vendorClient;
        this.vendorOverviewMapper = vendorOverviewMapper;
        this.createVendorInputMapper = createVendorInputMapper;
    }

    @GetMapping(
            value = "/vendors",
            params = "action=getAll"
    )
    public List<VendorOverviewView> getVendorOverview() {
        return this.vendorClient.getAllVendors().stream()
                .map(vendorOverviewMapper::map)
                .collect(Collectors.toList());
    }

    @PostMapping(
            value = "/vendors",
            params = "action=new"
    )
    public VendorOverviewView createNewVendor(@RequestBody CreateVendorInput createVendorInput) {
        this.vendorClient.saveVendor(this.createVendorInputMapper.map(createVendorInput));

        return null;
    }
}
