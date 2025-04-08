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

    /**
     * 내 쿠폰 조회 - 쿼리 메서드
     * 1. findAllByMemberUuid : 멤버 UUID 로 조회
     * 2. findByMemberUuidAndCouponStatus : 멤버 UUID 와 CouponStatus 로 조회
     * 3. findByMemberUuidAndCouponStatus : 멤버 UUID 와 CouponStatusList 로 조회
     */

    /**
     * 1. findAllByMemberUuid : 멤버 UUID 로 조회
     * @param memberUuid
     * @param pageable
     * @return
     */
    Page<MemberCoupon> findAllByMemberUuid(String memberUuid, Pageable pageable);

    /**
     * 2. findByMemberUuidAndCouponStatus : 멤버 UUID 와 CouponStatus 로 조회
     * @param memberUuid
     * @param couponStatus
     * @param pageable
     * @return
     */
    Page<MemberCoupon> findByMemberUuidAndCouponStatus(String memberUuid, CouponStatus couponStatus, Pageable pageable);

    /**
     * 3. findByMemberUuidAndCouponStatus : 멤버 UUID 와 CouponStatusList 로 조회
     * @param memberUuid
     * @param couponStatusCollection
     * @return
     */
    /**
     * [Q] Collection 을 사용한 이유?
     * JPA 입장에서 순서가 필요 없기 때문에 List 보다는 유연한 Collection 사용
     */
    Page<MemberCoupon> findByMemberUuidAndCouponStatusIn(String memberUuid, Collection<CouponStatus> couponStatusCollection, Pageable pageable);
}
