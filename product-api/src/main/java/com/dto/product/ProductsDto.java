package com.dto.product;

import java.util.ArrayList;
import java.util.List;

public class ProductsDto {
	private List<ProductDetails> products = new ArrayList<ProductDetails>();

	public ProductsDto(List<ProductDetails> products) {
		this.products = products;
	}
	public List<ProductDetails> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDetails> products) {
		this.products = products;
	}
	

}
