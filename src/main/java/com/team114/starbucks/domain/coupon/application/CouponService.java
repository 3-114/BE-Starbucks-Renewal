package com.team114.starbucks.domain.coupon.application;

import com.team114.starbucks.domain.coupon.dto.in.CreateCouponReqDto;
import com.team114.starbucks.domain.coupon.dto.in.UpdateCouponReqDto;
import com.team114.starbucks.domain.coupon.dto.out.CreateCouponResDto;
import com.team114.starbucks.domain.coupon.dto.out.GetAllCouponsResDto;
import com.team114.starbucks.domain.coupon.dto.out.GetCouponResDto;
import com.team114.starbucks.domain.coupon.dto.out.UpdateCouponResDto;
import com.team114.starbucks.domain.coupon.vo.out.UpdateCouponResVo;

import java.util.List;

public interface CouponService {

    /**
     * api/v1/coupon
     * 1. 쿠폰 생성
     * 2. 쿠폰 전체 조회
     * 3. 쿠폰 UUID -> 단건 조회
     * 4. 쿠폰 정보 변경
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

    /**
     * 3. 쿠폰 UUID -> 단건 조회
     * @param  couponUuid
     * @return getCouponResDto
     * @throws
     */
    GetCouponResDto findCouponByUuid(String couponUuid);

    /**
     * 4. 쿠폰 정보 변경
     * @param couponUuid, updateCouponReqDto
     * @return updateCouponResDto
     * @throws
     */
    UpdateCouponResDto updateCoupon(String couponUuid, UpdateCouponReqDto updateCouponReqDto);
}
