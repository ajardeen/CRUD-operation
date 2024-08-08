package com.teluskopractices.simplewebapp.service;

import com.teluskopractices.simplewebapp.model.Product;
import com.teluskopractices.simplewebapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServices {
    @Autowired
    ProductRepo repo;

public List<Product> getProducts(){

    return repo.findAll();
}


  public Product getProductById(int proId) {
    return repo.findById(proId).orElse(new Product());
  }

  public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
    product.setImageName(imageFile.getOriginalFilename());
    product.setImageType(imageFile.getContentType());
    product.setImageData(imageFile.getBytes());
    return repo.save(product);
  }
  public void updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
    product.setImageName(imageFile.getOriginalFilename());
    product.setImageType(imageFile.getContentType());
    product.setImageData(imageFile.getBytes());
    repo.save(product);
  }

    public void deleteProduct(int proid) {

    repo.deleteById(proid);
    }
}
