package com.example.orderservice.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProductDTO {

    private Long id;
    private Long categoryId;
    private String title;
    private String description;
    private String image;
    private Double price;
    private Rating rating;

    private CategoryDTO category;

}
