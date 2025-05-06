package com.mehul.e.commerce.controller;

import com.mehul.e.commerce.DTO.ProductRequestDTO;
import com.mehul.e.commerce.entity.Product;
import com.mehul.e.commerce.response.ResponseHandler;
import com.mehul.e.commerce.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mehul")
@Tag(name = "PRODUCT", description = "PRODUCT management APIs")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Get all products", description = "Gets all the Products. The API fetches all the products details from the DB .")
    @GetMapping("/products")
    public ResponseEntity<Object> getProducts(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "category") String sortBy,
            @RequestParam(defaultValue = "asc") String order
    ) {
        Map<String, Object> product = productService.fetchProductByNameOrBrand(search, size, page, sortBy, order);
        return ResponseHandler.responseBuilder("Products fetched successfully", HttpStatus.OK, product);
    }

    @Operation(summary = "Get product by ID", description = "Gets the Product by ID. The API fetches product details from the DB of specific ID.")
    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProductsById(
            @PathVariable UUID id
    ) {
        Product product = productService.getProductsById(id);
        if (product == null) {
            return ResponseHandler.responseBuilder("No Product found for that specific ID", HttpStatus.NOT_FOUND, null);
        }
        return ResponseHandler.responseBuilder("Products fetched successfully", HttpStatus.OK, product);
    }

    @Operation(summary = "Save a product", description = "Saves a new Product. The API saves a new Product.")
    @PostMapping("/products")
    public ResponseEntity<Object> saveProduct(
            @RequestBody ProductRequestDTO productRequestDTO
            ) {
        Product product = productService.saveProduct(productRequestDTO);
        return ResponseHandler.responseBuilder("Products fetched successfully", HttpStatus.OK, product);
    }

}