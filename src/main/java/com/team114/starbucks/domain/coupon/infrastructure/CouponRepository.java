package com.team114.starbucks.domain.coupon.infrastructure;

import com.team114.starbucks.domain.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    Optional<Coupon> findByCouponUuid(String couponUuid);

}
