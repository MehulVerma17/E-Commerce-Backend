package com.mehul.e.commerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mehul.e.commerce.enums.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
public class Product {

    @Id
    private UUID id;
    private String name;
    private String description;
    private double price;
    private String brand;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String image;

}
