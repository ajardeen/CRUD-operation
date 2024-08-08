package com.teluskopractices.simplewebapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
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
     @JsonFormat(pattern = "yyyy/MM/dd")
     @Column(name = "releasedate")
     private Date releasedate;
     private Boolean productAvailable;
     private Integer  stockQuantity;
     //image
     private String imageName;
     private String imageType;
     @Lob
     @Column(name = "image_data",length=100000)
     private byte[] imageData;

}
