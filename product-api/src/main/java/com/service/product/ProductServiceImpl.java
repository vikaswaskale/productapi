package com.service.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.mapper.product.MapToProductDto;
import com.dto.product.ProductDetails;
import com.dto.product.ProductsDto;
import com.entity.product.Product;
import com.repository.product.ProductRepository;

/***
 * 
 * @author niku sharma
 * @implNote - A Business service implementation to Product Service
 *
 */
@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	
	@Override
	public ProductsDto fetchProducts() {
		
		List<Product> products = productRepository.findAll();
		
		List<ProductDetails> productDtos = new ArrayList<ProductDetails>();
		
		for (Product product : products) {
			productDtos.add(MapToProductDto.mapToDto(product));
		}
		
		ProductsDto productsDto = new ProductsDto(productDtos);
		
		return productsDto;
	}

}
