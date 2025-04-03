package com.team114.starbucks.domain.coupon.application;

import com.team114.starbucks.domain.coupon.dto.in.CreateCouponReqDto;
import com.team114.starbucks.domain.coupon.dto.out.CreateCouponResDto;
import com.team114.starbucks.domain.coupon.dto.out.GetAllCouponsResDto;
import com.team114.starbucks.domain.coupon.vo.out.GetAllCouponsResVo;

import java.util.List;

public interface CouponService {

    /**
     * api/v1/coupon
     * 1. 쿠폰 생성
     * 2. 쿠폰 전체 조회
     */

    /**
     * 1. 쿠폰 생성
     * @param createCouponReqDto
     * @return createCouponResDto
     * @throws
     */
    CreateCouponResDto saveCoupon(CreateCouponReqDto createCouponReqDto);

    /**
     * 2. 쿠폰 전체 조회
     * @param
     * @return List<GetAllCouponsResDto>
     * @throws
     */
    List<GetAllCouponsResDto> findAllCoupons();
}
