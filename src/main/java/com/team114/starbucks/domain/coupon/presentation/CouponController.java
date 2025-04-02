package com.team114.starbucks.domain.coupon.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.coupon.application.CouponService;
import com.team114.starbucks.domain.coupon.dto.in.CreateCouponReqDto;
import com.team114.starbucks.domain.coupon.vo.in.CreateCouponReqVo;
import com.team114.starbucks.domain.coupon.vo.out.CreateCouponResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/coupon")
public class CouponController {

    private final CouponService couponService;

    /**
     * api/v1/coupon
     * 1. 쿠폰 생성
     */

    /**
     * 1. 쿠폰 생성
     * @param createCouponReqVo
     * @return createCouponResVo
     * @throws
     */
    @PostMapping
    public BaseResponseEntity<CreateCouponResVo> createCoupon(
            @RequestBody CreateCouponReqVo createCouponReqVo
    ) {
        CreateCouponResVo result = couponService.saveCoupon(CreateCouponReqDto.from(createCouponReqVo)).toVo();
        return new BaseResponseEntity<>("쿠폰이 생성되었습니다.", result);
    }

}
