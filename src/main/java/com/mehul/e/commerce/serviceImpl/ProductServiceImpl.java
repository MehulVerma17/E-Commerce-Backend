package com.mehul.e.commerce.serviceImpl;

import com.mehul.e.commerce.DTO.ProductRequestDTO;
import com.mehul.e.commerce.entity.Product;
import com.mehul.e.commerce.enums.Category;
import com.mehul.e.commerce.exceptions.CategoryNotFoundException;
import com.mehul.e.commerce.repository.ProductRepository;
import com.mehul.e.commerce.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Map<String, Object> fetchProductByNameOrBrand(String search, Integer size, Integer page, String sortBy, String order) {
        Map<String, Object> finalData = new HashMap<>();
        Sort.Direction sortDirection = order.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by(sortDirection,sortBy));
        if (search == null || search.isBlank()) {
            Page<Product> products = productRepository.findAll(pageRequest);
            finalData.put("products", products.getContent());
            finalData.put("total", products.getTotalElements());
            finalData.put("page", page);
            finalData.put("size", size);
            return finalData;
        }
        Page<Product> products =  productRepository.findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(search, search, pageRequest);
        finalData.put("products", products.getContent());
        finalData.put("total", products.getTotalElements());
        finalData.put("page", page);
        finalData.put("size", size);
        return finalData;
    }

    @Override
    public Product getProductsById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(ProductRequestDTO productRequestDTO) {
        try {
            Category category = Category.valueOf(productRequestDTO.getCategory());
        } catch (IllegalArgumentException e) {
            throw new CategoryNotFoundException("Category not found: " + productRequestDTO.getCategory());
        }
        Product product = new Product();
        BeanUtils.copyProperties(productRequestDTO, product);
        product.setId(UUID.randomUUID());
        return productRepository.save(product);
    }
}