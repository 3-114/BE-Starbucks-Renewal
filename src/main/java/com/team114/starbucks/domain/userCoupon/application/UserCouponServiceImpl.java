package com.team114.starbucks.domain.userCoupon.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.coupon.entity.Coupon;
import com.team114.starbucks.domain.coupon.enums.CouponStatus;
import com.team114.starbucks.domain.coupon.infrastructure.CouponRepository;
import com.team114.starbucks.domain.userCoupon.dto.in.IssueCouponReqDto;
import com.team114.starbucks.domain.userCoupon.entity.UserCoupon;
import com.team114.starbucks.domain.userCoupon.infrastructure.UserCouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCouponServiceImpl implements UserCouponService {

    private final UserCouponRepository userCouponRepository;
    private final CouponRepository couponRepository;

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
    @Override
    public Void issueCoupon(String memberUuid, IssueCouponReqDto issueCouponReqDto) {

        // [1] couponUuid 로 coupon 조회
        Coupon coupon = couponRepository.findByCouponUuid(issueCouponReqDto.getCouponUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        // [2] userCoupon build
        UserCoupon userCoupon = UserCoupon.builder()
                .coupon(coupon)
                .memberUuid(memberUuid)
                .couponStatus(CouponStatus.COUPON_ISSUED)
                .issued(true)
                .issuedAt(LocalDateTime.now())
                .used(false)
                .usedAt(null)
                .build();

        // [3] userCoupon 저장
        userCouponRepository.save(userCoupon);

        return null;
    }
}
