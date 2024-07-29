package com.teluskopractices.simplewebapp.controller;

import com.teluskopractices.simplewebapp.model.Product;
import com.teluskopractices.simplewebapp.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {

    ProductServices ser;

    @Autowired    //Constructer autowired
    public ProductController(ProductServices ser) {
        this.ser = ser;
    }

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
        if(ser.addProduct(product).equals("added"))
        return "Succesfully added  "+str;
        else
            return "Failed to add Product";
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