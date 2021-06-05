package com.vikas.coupon.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.coupon.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long>{

	Coupon findbyCode(String code);

}
