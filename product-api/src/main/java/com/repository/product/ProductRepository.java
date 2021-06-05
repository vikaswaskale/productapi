package com.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.product.Product;

/***
 * 
 * @author niku sharma
 * @implNote - A DAO interface to Product and linked with JPA for Product Table
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long>
{

}
