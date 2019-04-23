package com.taim.content.controller;

import com.taim.content.mapper.CreateProductInputMapper;
import com.taim.content.mapper.ProductDetailMapper;
import com.taim.content.mapper.ProductOverviewViewMapper;
import com.taim.content.model.CreateProductInput;
import com.taim.content.model.ProductDetailView;
import com.taim.content.model.ProductOverviewView;
import com.taim.taimbackendservicejavaclient.client.ProductClient;
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
    public List<ProductOverviewView> getAllProducts() {
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
