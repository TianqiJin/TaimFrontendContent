package com.taim.taimwebcontent.controller;

import com.taim.taimbackendservicejavaclient.client.VendorClient;
import com.taim.taimwebcontent.mapper.CreateVendorInputMapper;
import com.taim.taimwebcontent.mapper.VendorOverviewMapper;
import com.taim.taimwebcontent.model.CreateVendorInput;
import com.taim.taimwebcontent.model.VendorOverviewView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
