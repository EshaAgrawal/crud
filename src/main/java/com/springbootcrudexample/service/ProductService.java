package com.springbootcrudexample.service;
import com.springbootcrudexample.entity.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {
     Product saveProduct(Product product);
     List<Product> saveProducts(List<Product> products) ;
     @Cacheable
     List<Product> getProducts(Integer pageNo, Integer pageSize, String sortBy);
     Product getProductById(int id);
     Product getProductByName(String name);
     String deleteProduct(int id);
     Product updateProduct(Product product);
}
