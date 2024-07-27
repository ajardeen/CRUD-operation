package com.teluskopractices.simplewebapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;


@Component
@Entity
public class Product {

     @Id
     private int ProID;
     private String ProName;
     private int ProPrice;


     public Product(int proID, String proName, int proPrice) {
          ProID = proID;
          ProName = proName;
          ProPrice = proPrice;
     }

     public Product() {
     }

     public int getProID() {
          return ProID;
     }

     public void setProID(int proID) {
          ProID = proID;
     }

     public String getProName() {
          return ProName;
     }

     public void setProName(String proName) {
          ProName = proName;
     }

     public int getProPrice() {
          return ProPrice;
     }

     public void setProPrice(int proPrice) {
          ProPrice = proPrice;
     }

     @Override
     public String toString() {
          return "Product{" +
                  "ProID=" + ProID +
                  ", ProName='" + ProName + '\'' +
                  ", ProPrice=" + ProPrice +
                  '}';
     }
}
