package com.fresheats.fresh.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString()
public class ProductEntity extends BaseEntity {

    @Column(name = "Product_Name",length = 25)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "Category_Id")
    private CategoryEntity categoryId;

    @Column(name = "Stock_Quantity")
    private  Integer stockQuantity;

    @Column(name = "Product_Description")
    @Lob
    private String productDescription;

    @Column(name = "Product_Price")
    private Double productPrice;

    @Column(name = "Created_At")
    private LocalDateTime createdAt;

    @Column(name = "Updated_At")
    private LocalDateTime updatedAt;

    @Column(name="Image_Url",length = 500)
    private String imageUrl;

}
