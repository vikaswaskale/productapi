package com.vikas.product.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
