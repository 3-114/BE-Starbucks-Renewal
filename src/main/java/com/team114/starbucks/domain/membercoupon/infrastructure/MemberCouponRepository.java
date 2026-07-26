package com.team114.starbucks.domain.membercoupon.infrastructure;

import com.team114.starbucks.domain.membercoupon.entity.MemberCoupon;
import com.team114.starbucks.domain.membercoupon.enums.CouponStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface MemberCouponRepository extends JpaRepository<MemberCoupon, Long> {

    Optional<MemberCoupon> findByMemberUuidAndCoupon_CouponUuid(String memberUuid, String couponUuid);

    Page<MemberCoupon> findAllByMemberUuid(String memberUuid, Pageable pageable);

    Page<MemberCoupon> findByMemberUuidAndCouponStatus(String memberUuid, CouponStatus couponStatus, Pageable pageable);

    Page<MemberCoupon> findByMemberUuidAndCouponStatusIn(String memberUuid, Collection<CouponStatus> couponStatusCollection, Pageable pageable);

}