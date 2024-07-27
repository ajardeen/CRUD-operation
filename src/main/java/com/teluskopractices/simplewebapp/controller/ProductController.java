package com.teluskopractices.simplewebapp.controller;

import com.teluskopractices.simplewebapp.model.Product;
import com.teluskopractices.simplewebapp.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
public class ProductController {

    @Autowired
    ProductServices ser;

    @GetMapping("/products")
    public List<Product> getProduct(){
        return ser.getProducts();
    }

    @GetMapping("/products/{proId}")
    public Product getProductById(@PathVariable int proId){
        return ser.getProductById(proId);
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody Product product){
        System.out.println(product);
        ser.addProduct(product);
        String str=product.toString();
        return "Succesfully added  "+str;
    }

    @PutMapping("/products")
    public String updateProduct(@RequestBody Product product){
        System.out.println(product.toString());
        ser.updateProduct(product);
        return "Updated Succefully";
    }

    @DeleteMapping("/products/{proid}")
    public String deleteProduct(@PathVariable int proid){
        ser.deleteProduct(proid);
        return "Deleted Succefully";

    }
}