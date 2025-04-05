package com.team114.starbucks.domain.userCoupon.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.userCoupon.application.UserCouponService;
import com.team114.starbucks.domain.userCoupon.dto.in.IssueCouponReqDto;
import com.team114.starbucks.domain.userCoupon.vo.in.IssueCouponReqVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/my-coupons")
public class UserCouponController {

    private final UserCouponService userCouponService;

    /**
     * /api/v1/my-coupons
     * 1. 쿠폰 받기 (쿠폰 발행하기)
     * 2. 쿠폰 사용하기
     */

    /**
     * 1. 쿠폰 받기
     * @param memberUuid, issueCouponReqVo
     * @return
     * @throws
     */
    @PostMapping("/issue")
    public BaseResponseEntity<Void> issueCoupon(
            @RequestHeader("Member-Uuid") String memberUuid,    // member UUID
            @RequestBody IssueCouponReqVo issueCouponReqVo      // Coupon UUID
    ) {
        userCouponService.issueCoupon(memberUuid, IssueCouponReqDto.from(issueCouponReqVo));
        return new BaseResponseEntity<>("쿠폰이 발행되었습니다.");
    }

    /**
     * 2. 쿠폰 사용하기
     * @param
     * @return
     * @throws
     */

}
