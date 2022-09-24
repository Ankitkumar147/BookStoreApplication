package com.bridgelabz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDto {

    public long bookId;
    public long userId;
    public Integer quantity;
    public double totalPrice;
}
