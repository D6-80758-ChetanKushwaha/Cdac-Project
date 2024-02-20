package com.app.dtos;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter

@ToString()
public class CatelogProd {

    private Long id;

    private String name;

    private String productDescription;

    private int stockQuantity;

    private double productPrice;

    private double discountedPrice;

    private double discountedPercent;

    private String imageUrl;

}
