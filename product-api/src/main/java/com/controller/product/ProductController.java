package com.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.product.ProductsDto;
import com.dto.product.TransactionDto;
import com.dto.product.TransactionsDto;
import com.service.product.ProductService;
import com.service.transaction.TransactionService;

/***
 * 
 * @author niku sharma
 * @apiNote - this REST API controller used to retrieve the - Product list -
 *          List of Transaction based on product type selected and its type -
 *          CD/DR/ALL
 *
 */

@RestController
@RequestMapping("/")
public class ProductController {

	/**
	 * Get ProductService to make a call from Repository
	 */

	@Autowired
	private ProductService productService;

	/**
	 * Get TransactionService to make a call from Repository
	 */
	@Autowired
	private TransactionService transactionService;

	/**
	 * REST END Point - /products
	 */

	@GetMapping("/products")
	public ProductsDto fetchProducts() {
		return productService.fetchProducts();
	}

	/**
	 * REST END Point - /transactions/{productId}
	 * @throws Exception 
	 * 
	 */

	@GetMapping("/transactions/{productId}")
	public TransactionsDto  fetchTransactions(@PathVariable("productId") String productId,
			@RequestParam("filterBy") List<String> filterBy) throws Exception {

		return transactionService.fetchTransactionByProductId(productId, filterBy);

	}

}
