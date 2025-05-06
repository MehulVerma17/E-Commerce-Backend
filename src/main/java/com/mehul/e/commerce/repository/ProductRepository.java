package com.mehul.e.commerce.repository;

import com.mehul.e.commerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    Page<Product> findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(String search, String search1, PageRequest pageRequest);
}