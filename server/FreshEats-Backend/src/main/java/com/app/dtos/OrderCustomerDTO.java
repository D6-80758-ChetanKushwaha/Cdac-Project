package com.app.dtos;

import java.time.LocalDateTime;

import com.app.entities.UserRole;

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
@Getter
@Setter
@Builder
@ToString
public class OrderCustomerDTO {
    private long id;

    private long customerId;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String address;

    private UserRole role;
}
