package com.team114.starbucks.domain.coupon.infrastructure;

import com.team114.starbucks.domain.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
