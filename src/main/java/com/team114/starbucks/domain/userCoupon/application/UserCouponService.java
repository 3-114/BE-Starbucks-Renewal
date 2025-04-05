package com.team114.starbucks.domain.userCoupon.application;

import com.team114.starbucks.domain.userCoupon.dto.in.IssueCouponReqDto;

public interface UserCouponService {

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

}
