package com.dto.mapper.product;

import com.dto.product.ProductDetails;
import com.entity.product.Product;

/***
 * 
 * @author niku sharma
 * @implNote - Map business object to DTO - a non JPA session POJO
 *
 */
public class MapToProductDto {

	public static ProductDetails mapToDto(Product product) {

		ProductDetails productDto = new ProductDetails();
		productDto.setAccountNumber(product.getAccountNumber());
		productDto.setAvailableBalance(product.getAvailableBalance());
		productDto.setCurrentBalance(product.getCurrentBalance());
		productDto.setId(product.getId());
		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setSortCode(product.getSortCode());

		return productDto;
	}
}
