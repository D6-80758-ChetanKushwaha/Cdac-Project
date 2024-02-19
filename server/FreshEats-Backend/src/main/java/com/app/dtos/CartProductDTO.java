package com.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString()
@AllArgsConstructor
@NoArgsConstructor
public class CartProductDTO {
    private long id;
    private CartDTO cart;
    private ProductDTO product;
    private int quantity;
    private double price;
}
