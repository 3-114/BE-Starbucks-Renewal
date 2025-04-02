package com.team114.starbucks.domain.coupon.application;

import com.team114.starbucks.domain.coupon.dto.in.CreateCouponReqDto;
import com.team114.starbucks.domain.coupon.dto.out.CreateCouponResDto;

public interface CouponService {

    /**
     * api/v1/coupon
     * 1. 쿠폰 생성
     */

    /**
     * 1. 쿠폰 생성
     * @param createCouponReqDto
     * @return createCouponResDto
     * @throws
     */
    CreateCouponResDto saveCoupon(CreateCouponReqDto createCouponReqDto);
}
