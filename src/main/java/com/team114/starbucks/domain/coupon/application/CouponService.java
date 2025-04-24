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

    CreateCouponResDto saveCoupon(CreateCouponReqDto createCouponReqDto);

    List<GetAllCouponsResDto> findAllCoupons();

    GetCouponResDto findCouponByUuid(String couponUuid);

    UpdateCouponResDto updateCoupon(String couponUuid, UpdateCouponReqDto updateCouponReqDto);

    void deleteCoupon(String couponUuid);
}
