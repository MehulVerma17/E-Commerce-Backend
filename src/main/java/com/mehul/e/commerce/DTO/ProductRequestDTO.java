package com.mehul.e.commerce.DTO;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductRequestDTO {
    @NonNull
    private String name;
    private String description;
    @NonNull
    private Double price;
    private String brand;
    @NonNull
    private String category;
    private String image;
}
