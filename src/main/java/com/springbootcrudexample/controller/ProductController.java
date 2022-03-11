package com.springbootcrudexample.controller;
import com.springbootcrudexample.SpringBootCrudExampleApplication;
import com.springbootcrudexample.entity.Product;
import com.springbootcrudexample.exception.RecordNotFoundException;
import com.springbootcrudexample.repository.ProductRepository;
import com.springbootcrudexample.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);


    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addListOfProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getAllProduct(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Product> list = productService.getProducts(pageNo, pageSize, sortBy);
        logger.info("Inside get api for getting list of data");
        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }
//
//            List<EmployeeEntity> list = service.getAllEmployees(pageNo, pageSize, sortBy);
//
//            return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
//        }
    // if()
    // Optional List<Product> products = productService.getProducts();
    //if(!products.is)
//
//        if (!products.isPresent())
//            throw new StudentNotFoundException("id-" + id);
//
//        Resource<Student> resource = new Resource<Student>(student.get());
//
//        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllStudents());
//
//        resource.add(linkTo.withRel("all-students"));
//
//        return resource;
//
//        logger.info("Inside get api for getting list of data");
//        return productService.getProducts();


    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable int id) {
        logger.info("Inside get product by id");
        return productService.getProductById(id);
    }

    @GetMapping("/getProductByName/{name}")
    public Product getProductByName(@PathVariable String name) {

        return productService.getProductByName(name);
    }

    @DeleteMapping("/deleteProductById/{id}")
    public String deleteProductById(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> fetchProductById(@PathVariable int id) {
        Product product = productRepository.findById(id).
                orElseThrow(() -> new RecordNotFoundException("Product not exist with id " + id));
        return ResponseEntity.ok(product);

    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello using rest template";
    }

    @GetMapping("/helloFromAnother")
    public String getHello() {
        String url = "http://localhost:8080/hello";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    @GetMapping("/sendEmail")
    public String sendMail() {
            return "Email send succesfully";
}



}
