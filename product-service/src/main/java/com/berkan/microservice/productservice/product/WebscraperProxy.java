package com.berkan.microservice.productservice.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "webscraper-service")
public interface WebscraperProxy {

    @PutMapping("/webscraper/grabInformation")
    Product grabInformation(@RequestBody String url);
}
