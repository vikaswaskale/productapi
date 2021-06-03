package com.vikas.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.vikas.product.entity.Product;

@SpringBootTest
class ProductwebApplicationTests {
    
	@Value("${product.restapi.services.url}")
	private String baseURL;
	
	@Test
	void testGetProduct() {
		System.out.println("BASE URL ---------------------: "+baseURL);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseURL +"product/5", Product.class);
		assertNotNull(product);
		assertEquals("Apple", product.getName());
		
	}
	
	@Test
	void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		long uniqueID = new Date().hashCode();
		product.setId(uniqueID);
		product.setDescription("Mango");
		product.setName("Mobile");
		product.setPrice(1000);
		Product newProduct = restTemplate.postForObject(baseURL+"saveproducts", product, Product.class);
		
		assertNotNull(newProduct);
		assertEquals("Mobile", newProduct.getName());
		
	}


}
