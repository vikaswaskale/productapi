package com.vikas.coupon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.coupon.model.Coupon;
import com.vikas.coupon.repos.CouponRepository;

@RestController
public class CoupenController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CoupenController.class);
	
	@Autowired
	private CouponRepository repos;
	
    @PostMapping("/coupon")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
    	LOGGER.info("Inside save coupon");
    	return repos.save(coupon);
		
	}
    
    @GetMapping("/coupon/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
    	LOGGER.info("Inside get coupon");
    	return repos.findByCode(code);
	}

}
