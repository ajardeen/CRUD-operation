package com.teluskopractices.simplewebapp.controller;

import com.teluskopractices.simplewebapp.model.Product;
import com.teluskopractices.simplewebapp.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
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

    //getALL
    @GetMapping("/products")
    public List<Product> getProduct(){
        return ser.getProducts();
    }
    //getImage
    @GetMapping("product/{productid}/image")
    public byte[] getImages(@PathVariable int productid){
        Product product1=ser.getProductById(productid);
        return product1.getImageData();
    }

    //getbyid
    @GetMapping("/product/{proId}")
    public Product getProductById(@PathVariable int proId){
        return ser.getProductById(proId);
    }

    //addproduct
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
                                     @RequestPart MultipartFile imageFile) throws IOException {

        ser.addProduct(product,imageFile);
        try {
            Product product1 = ser.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //updateProduct
    @PutMapping("/product/{id}")
    public String updateProduct(@RequestPart Product product,
                                @RequestPart MultipartFile imageFile,
                                @PathVariable int id) throws IOException {
        System.out.println(product.toString());
        ser.updateProduct(id,product,imageFile);
        return "Updated Succefully";
    }

    //deleteProduct
    @DeleteMapping("/product/{proid}")
    public String deleteProduct(@PathVariable int proid){
        ser.deleteProduct(proid);
        return "Deleted Succefully";

    }
}