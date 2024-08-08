package com.teluskopractices.simplewebapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;


@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name ="product")
public class Product {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer  id;
     private String name;
     @Column(name = "description")
     private String description;
     private String brand;
     private BigDecimal price;
     private String category;
     @DateTimeFormat()
     @Column(name = "releasedate")
     private Date releasedate;
     private Boolean productAvailable;
     private Integer  stockQuantity;
     //image
     private String imageName;
     private String imageType;
     @Lob
     @Column(name = "image_data")
     private byte[] imageData;

}
