package com.example.orderservice.dto;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CategoryDTO {

    private Long id;
    private String name;

}
