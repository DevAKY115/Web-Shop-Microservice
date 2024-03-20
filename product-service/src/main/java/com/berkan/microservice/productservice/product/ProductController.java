package com.berkan.microservice.productservice.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/product/add")
    public Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    @GetMapping("/product/id/{id}")
    public Product getProduct(@PathVariable int id){
        return service.grabProduct(id);
    }

    @GetMapping("/product/category/{category}")
    public List<Product> grabByCategory(@PathVariable String category){
        return service.grabByCategory(category);
    }

    @GetMapping("product/wishlist")
    public List<Product> grabByWishlist(@RequestBody List<Integer> idList){
        return service.wishlist(idList);
    }

    @GetMapping("/product/{page}")
    public List<Product> pageOfProducts(@PathVariable int page){
        return service.pageOfProducts(page);
    }

    @GetMapping("/product/grabInformation")
    public Product grabInformation(@RequestBody String url){

        return service.grabInformation(url);
    }
}
