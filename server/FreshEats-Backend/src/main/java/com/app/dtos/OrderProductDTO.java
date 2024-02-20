package com.app.dtos;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString()
public class OrderProductDTO {

    private long id;
    
    @NotBlank
    private long productId;

    private String name;

    private String description;

    @NotBlank
    private int quantity;

    @NotBlank
    private double price;

    private String sellerId;

    private String sellerName;

    private String sellerEmail;
}
