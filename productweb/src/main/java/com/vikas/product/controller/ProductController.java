package com.vikas.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.product.entity.Product;
import com.vikas.product.repos.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(value = "/products",method = RequestMethod.GET )
	public List<Product> getProducts() {
		
		return repository.findAll();
	}
	
	@RequestMapping(value = "/product/{id}",method = RequestMethod.GET )
	public Product getProduct(@PathVariable("id") long id) {
		
		return repository.findById(id).get();
	}

	
	@RequestMapping(value = "/saveproducts",method = RequestMethod.POST )
	public Product saveProduct(@RequestBody Product product) {
		LOGGER.info("Calling Save Products");
			return repository.save(product);
	}

	@RequestMapping(value = "/products",method = RequestMethod.PUT )
	public Product updateProduct(@RequestBody Product product) {
		
			return repository.save(product);
	}

	
	@RequestMapping(value = "/product/{id}",method = RequestMethod.DELETE )
	public void deleteProduct(@PathVariable("id") long id) {
		
		 repository.deleteById(id);
	}


}
