package com.team114.starbucks.domain.memberCoupon.infrastructure;

import com.team114.starbucks.domain.memberCoupon.entity.MemberCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberCouponRepository extends JpaRepository<MemberCoupon, Long> {

    Optional<MemberCoupon> findByMemberUuidAndCoupon_CouponUuid(String memberUuid, String couponUuid);

}
