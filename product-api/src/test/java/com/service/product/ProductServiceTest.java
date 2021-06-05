package com.service.product;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.dto.product.ProductsDto;
import com.entity.product.Product;
import com.repository.product.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductServiceImpl productService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void when_fetchProducts_returnList() {
		// given
		Product product = new Product();
		product.setAccountNumber("123456");
		product.setAvailableBalance(new BigDecimal(100.01));
		product.setCurrentBalance(new BigDecimal(122.22));
		product.setId(new BigDecimal(1111).longValueExact());
		product.setProductId("ID1");
		product.setProductName("Saving Account");
		product.setSortCode("11-11-11");

		List<Product> expectedProducts = Arrays.asList(product);

		when(productRepository.findAll()).thenReturn(expectedProducts);

		ProductsDto actualProducts = productService.fetchProducts();

		assertEquals(1, actualProducts.getProducts().size());
		assertEquals("123456", actualProducts.getProducts().get(0).getAccountNumber());
		assertEquals("11-11-11", actualProducts.getProducts().get(0).getSortCode());
		assertEquals("ID1", actualProducts.getProducts().get(0).getProductId());
	}
}
