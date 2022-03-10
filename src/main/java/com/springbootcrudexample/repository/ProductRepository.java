package com.springbootcrudexample.repository;

import com.springbootcrudexample.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

public interface ProductRepository extends PagingAndSortingRepository<Product, Serializable> {
    Product findByName(String name);
}
