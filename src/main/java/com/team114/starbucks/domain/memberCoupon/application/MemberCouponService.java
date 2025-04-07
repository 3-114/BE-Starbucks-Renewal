package com.team114.starbucks.domain.memberCoupon.application;

import com.team114.starbucks.domain.memberCoupon.dto.in.IssueCouponReqDto;
import com.team114.starbucks.domain.memberCoupon.dto.in.ConsumeCouponReqDto;
import com.team114.starbucks.domain.memberCoupon.dto.out.MyCouponResDto;
import com.team114.starbucks.domain.memberCoupon.enums.CouponViewFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberCouponService {

    /**
     * /api/v1/my-coupons
     * 1. 쿠폰 받기 (쿠폰 발행하기)
     * 2. 쿠폰 사용하기
     * 3. 내 쿠폰 조회
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

    /**
     * 3. 내 쿠폰 조회
     * @param memberUuid, status, pageable
     * @return Page<MyCouponResDto>
     * @throws
     */
    Page<MyCouponResDto> getMyCoupons(
            String memberUuid,
            CouponViewFilter status,
            Pageable pageable
    );
}
