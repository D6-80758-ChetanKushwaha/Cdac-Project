package com.fresheats.fresh.entities;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "User_ID", nullable = false)
    private UserEntity  user; // Assuming you have a User entity defined that maps to your Users table

    @OneToMany(mappedBy = "order")
    private List<OrderDetailsEntity> orderDetails;

    @Column(name = "Total_Price", nullable = false)
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private OrderStatus status;

//    We have to create Enum for this...
//    @Column(name = "Payment_Method", nullable = false)
//    private String paymentMethod;

    @Column(name = "Created_At", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "Updated_At", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "ShippingAddress")
    @Lob
    private String shippingAddress; 


}
