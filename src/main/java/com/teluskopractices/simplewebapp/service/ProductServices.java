package com.teluskopractices.simplewebapp.service;

import com.teluskopractices.simplewebapp.model.Product;
import com.teluskopractices.simplewebapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServices {
    @Autowired
    ProductRepo repo;

//  List<Product> products = new ArrayList<>(Arrays.asList(
//          new Product(1,"mango",100),
//          new Product(2,"Apple",120),
//          new Product(3,"Grapes",40)));

public List<Product> getProducts(){

    return repo.findAll();
}


  public Product getProductById(int proId) {
    return repo.findById(proId).orElse(new Product(0,"Not Found",0));
//    return products.stream()
//            .filter(p->p.getProID()==proId)
//            .findFirst().orElse(new Product(0,"Not Found",0));
  }

  public void addProduct(Product product) {
//         products.add(product);
      repo.save(product);
  }

  public void updateProduct(Product product) {

    repo.save(product);
//      for(int i=0;i<products.size();i++){
//        if(products.get(i).getProID()==product.getProID()){
//            products.set(i,product);
//        }
//      }
  }

    public void deleteProduct(int proid) {

    repo.deleteById(proid);
//    for(int a=0;a<products.size();a++){
//        if(products.get(a).getProID()==proid){
//            products.remove(a);
//        }
//    }
    }
}
