package com.springbootcrudexample.service;

import com.springbootcrudexample.entity.Product;
import com.springbootcrudexample.exception.RecordNotFoundException;
import com.springbootcrudexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@CacheConfig(cacheNames = "product")
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl( ProductRepository productRepository ) {
        this.productRepository = productRepository;
    }
    @Transactional
    @Override
    public Product saveProduct(Product product){
        if (product == null) {
            throw new RecordNotFoundException("Empty product");
        } else {
            return productRepository.save(product);
        }
    }
    @Override
    public List<Product> saveProducts(List<Product> products) {
        return null;
               // productRepository.saveAll(products);
    }
    @Override
    @Cacheable
    public List<Product> getProducts(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("name"));
        Page<Product> pagedResult = productRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Product>();
        }    }

    @Override
    @Transactional
    @Cacheable
    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }
    @Override
    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }
    @Override
    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "Product" + " " + id + " " + "deleted";
    }
    @Override
    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setName(product.getName());
        return productRepository.save(existingProduct);
    }
}
