package com.team114.starbucks.domain.coupon.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.coupon.dto.in.CreateCouponReqDto;
import com.team114.starbucks.domain.coupon.dto.out.CreateCouponResDto;
import com.team114.starbucks.domain.coupon.entity.Coupon;
import com.team114.starbucks.domain.coupon.infrastructure.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

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
    @Transactional
    @Override
    public CreateCouponResDto saveCoupon(CreateCouponReqDto createCouponReqDto) {

        try {

            // [1] dto -> entity repository 에 저장
            Coupon newCoupon = createCouponReqDto.toEntity(UUID.randomUUID().toString());

            // [2] repository 에 저장
            Coupon savedCoupon = couponRepository.save(newCoupon);

            // [3] entity -> dto
            return CreateCouponResDto.from(savedCoupon);

        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_SAVE);
        }
    }
}
