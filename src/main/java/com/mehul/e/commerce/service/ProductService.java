package com.mehul.e.commerce.service;

import com.mehul.e.commerce.DTO.ProductRequestDTO;
import com.mehul.e.commerce.entity.Product;

import java.util.Map;
import java.util.UUID;

public interface ProductService {

    Map<String, Object> fetchProductByNameOrBrand(String search, Integer size, Integer page, String sortBy, String order);

    Product getProductsById(UUID id);

    Product saveProduct(ProductRequestDTO productRequestDTO);
}
