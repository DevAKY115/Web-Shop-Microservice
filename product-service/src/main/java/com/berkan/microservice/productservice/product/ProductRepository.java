package com.berkan.microservice.productservice.product;

import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(String category);

    Product findByUrl(String url);
}
