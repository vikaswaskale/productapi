package com.service.product;

import com.dto.product.ProductsDto;
/***
 * 
 * @author niku sharma
 * @implNote - A Business service interface to Product Service
 *
 */
public interface ProductService {
	
	/***
	 * @return productDtos
	 */
	
	public ProductsDto  fetchProducts();

}
