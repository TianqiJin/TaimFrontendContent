package com.taim.taimwebcontent.controller;

import com.taim.taimbackendservicejavaclient.client.ProductClient;
import com.taim.taimwebcontent.mapper.CreateProductInputMapper;
import com.taim.taimwebcontent.mapper.ProductDetailMapper;
import com.taim.taimwebcontent.mapper.ProductOverviewViewMapper;
import com.taim.taimwebcontent.model.CreateProductInput;
import com.taim.taimwebcontent.model.ProductDetailView;
import com.taim.taimwebcontent.model.ProductOverviewView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductResourceController {

    private final ProductClient productClient;
    private final ProductOverviewViewMapper productOverviewViewMapper;
    private final ProductDetailMapper productDetailMapper;
    private final CreateProductInputMapper createProductInputMapper;

    @Autowired
    public ProductResourceController(ProductClient productClient,
                                     ProductOverviewViewMapper productOverviewViewMapper,
                                     ProductDetailMapper productDetailMapper,
                                     CreateProductInputMapper createProductInputMapper) {
        this.productClient = productClient;
        this.productOverviewViewMapper = productOverviewViewMapper;
        this.productDetailMapper = productDetailMapper;
        this.createProductInputMapper = createProductInputMapper;
    }

    @GetMapping(
            value = "/products",
            params = "action=getAll"
    )
    public List<ProductOverviewView> getAllProducts() throws InterruptedException {
        return this.productClient.getAllProducts().stream()
                .map(productOverviewViewMapper::map)
                .collect(Collectors.toList());

    }

    @GetMapping(
            value = "/products",
            params="action=getById"
    )
    public ProductDetailView getProductDetailById(@RequestParam("id")Long productId) {
        return productDetailMapper.map(this.productClient.getProductById(productId));
    }

    @PostMapping(
            value = "/products",
            params = "action=new"
    )
    public ProductOverviewView createNewProduct(@RequestBody CreateProductInput createProductInput) {
        productClient.createNewProduct(this.createProductInputMapper.map(createProductInput));

        return null;
    }

}
