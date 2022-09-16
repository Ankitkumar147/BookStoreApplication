package com.bridgelabz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
    private String name;
    private String author;
    private String description;
    private int price;
    private Integer quantity;
}