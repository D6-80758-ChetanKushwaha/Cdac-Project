package com.app.entities;

import lombok.*;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString()
public class ProductEntity extends BaseEntity {

	private Integer productNos;
	
//    @ManyToOne()
//    @JoinColumn(name = "category_id")
//    private CategoryEntity categoryId;

    /*
     * one-to-many relationship where one seller can have multiple products but
     * each product belongs to only one seller, then a unidirectional relationship
     * from Product to Seller would be sufficient .
     * This means that each Product entity would have a reference to its associated
     * Seller,
     * but the Seller entity would not have a direct reference back to its
     * associated products.
     * You can easily retrieve the seller's products by querying the Product entity
     * based on the seller's ID.
     */

//     @ManyToOne(fetch = FetchType.EAGER) // Each seller can have multiple products
//     //-->Unidirectional
//     @JoinColumn(name = "seller_id")
//     private SellerEntity sellerId;

    // @OneToMany
    // @JoinColumn(name = "cart_id")
    // private CartEntity cartId;

    @Column(name = "product_name", length = 25)
    private String name;

    @Column(name = "product_description")
    @Lob
    private String productDescription;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "discounted_price")
    private double discountedPrice;

    @Column(name = "discounted_percent")
    private double discountedPercent;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
