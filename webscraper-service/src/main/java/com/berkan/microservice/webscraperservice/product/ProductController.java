package com.berkan.microservice.webscraperservice.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {


    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PutMapping("/webscraper/grabInformation")
    public Product grabInformation(@RequestBody String url){

        return service.grabInformation(url);
    }

}
