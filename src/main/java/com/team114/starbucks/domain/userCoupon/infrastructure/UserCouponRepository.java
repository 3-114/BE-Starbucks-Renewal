package com.team114.starbucks.domain.userCoupon.infrastructure;

import com.team114.starbucks.domain.userCoupon.entity.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCouponRepository extends JpaRepository<UserCoupon, Long> {
}
