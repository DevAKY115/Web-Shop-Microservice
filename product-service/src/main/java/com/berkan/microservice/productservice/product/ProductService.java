package com.berkan.microservice.productservice.product;
;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;
    private WebscraperProxy proxy;

    public ProductService(ProductRepository repository, WebscraperProxy proxy) {
        this.repository = repository;
        this.proxy = proxy;
    }

    public Product grabProduct(int id){

        if(repository.findById(id).isEmpty()){

            throw new RuntimeException("ProductNotFound: " + id);
            //TODO implement proper Exceptions
        }

        Product result = repository.findById(id).get();

        return result;
    }

    public Product addProduct(Product product){

        return repository.save(product);
    }

    public List<Product> wishlist(List<Integer> productIds){

        List<Product> result = new LinkedList<>();

        for(int id : productIds){
            if(repository.findById(id).isPresent()){
                result.add(repository.findById(id).get());
            }
        }

        return result;

    }

    public List<Product> pageOfProducts(int page){
        Page<Product> result = repository.findAll(
                PageRequest.of(page,10,
                        Sort.by(Sort.Direction.ASC, "productId")));

        return result.toList();

    }

    public List<Product> grabByCategory(String category){
        return repository.findByCategory(category);
    }

    public Product grabInformation(String url){

        if(repository.findByUrl(url) == null){
            return proxy.grabInformation(url);
        }

        return repository.findByUrl(url);
    }
}
