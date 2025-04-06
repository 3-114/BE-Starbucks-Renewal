package com.team114.starbucks.domain.memberCoupon.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.memberCoupon.application.MemberCouponService;
import com.team114.starbucks.domain.memberCoupon.dto.in.IssueCouponReqDto;
import com.team114.starbucks.domain.memberCoupon.dto.in.UseCouponReqDto;
import com.team114.starbucks.domain.memberCoupon.vo.in.IssueCouponReqVo;
import com.team114.starbucks.domain.memberCoupon.vo.in.UseCouponReqVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/my-coupons")
public class MemberCouponController {

    private final MemberCouponService userCouponService;

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
            // X- 접두사로 커스텀 헤더임을 명시적으로 표시
            @RequestHeader("X-Member-UUID") String memberUuid,    // member UUID
            @RequestBody IssueCouponReqVo issueCouponReqVo        // Coupon UUID
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
    @PutMapping("/use")
    public BaseResponseEntity<Void> useCoupon(
            // X- 접두사로 커스텀 헤더임을 명시적으로 표시
            @RequestHeader("X-Member-UUID") String memberUuid,    // member UUID
            @RequestBody UseCouponReqVo useCouponReqVo            // Coupon UUID
    ) {
        userCouponService.useCoupon(memberUuid, UseCouponReqDto.from(useCouponReqVo));
        return new BaseResponseEntity<>("쿠폰이 사용 되었습니다.");
    }
}
