package com.team114.starbucks.domain.memberCoupon.application;

import com.team114.starbucks.domain.memberCoupon.dto.in.IssueCouponReqDto;
import com.team114.starbucks.domain.memberCoupon.dto.in.ConsumeCouponReqDto;

public interface MemberCouponService {

    /**
     * /api/v1/my-coupons
     * 1. 쿠폰 받기 (쿠폰 발행하기)
     * 2. 쿠폰 사용하기
     */

    /**
     * 1. 쿠폰 받기
     * @param memberUuid, issueCouponReqDto
     * @return
     * @throws
     */
    Void issueCoupon(String memberUuid, IssueCouponReqDto issueCouponReqDto);

    /**
     * 2. 쿠폰 사용하기
     * @param memberUuid, useCouponReqDto
     * @return
     * @throws
     */
    Void consumeCoupon(String memberUuid, ConsumeCouponReqDto useCouponReqDto);
}
