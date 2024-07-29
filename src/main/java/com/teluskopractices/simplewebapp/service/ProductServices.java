package com.teluskopractices.simplewebapp.service;

import com.teluskopractices.simplewebapp.model.Product;
import com.teluskopractices.simplewebapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServices {
    @Autowired
    ProductRepo repo;

public List<Product> getProducts(){

    return repo.findAll();
}


  public Product getProductById(int proId) {
    return repo.findById(proId).orElse(new Product(0,"Not Found",0));
  }

  public String addProduct(Product product) {
    if(product.getProName().equals("null")){
        return "no data";
    }else {
        repo.save(product);
        return "added";
    }
  }

  public void updateProduct(Product product) {

    repo.save(product);
  }

    public void deleteProduct(int proid) {

    repo.deleteById(proid);
    }
}
