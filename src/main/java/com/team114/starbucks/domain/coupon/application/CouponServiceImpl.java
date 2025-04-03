package com.team114.starbucks.domain.coupon.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.coupon.dto.in.CreateCouponReqDto;
import com.team114.starbucks.domain.coupon.dto.out.CreateCouponResDto;
import com.team114.starbucks.domain.coupon.dto.out.GetAllCouponsResDto;
import com.team114.starbucks.domain.coupon.entity.Coupon;
import com.team114.starbucks.domain.coupon.infrastructure.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

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

    /**
     * 2. 쿠폰 전체 조회
     * @param
     * @return List<GetAllCouponsResDto>
     * @throws
     */
    @Override
    public List<GetAllCouponsResDto> findAllCoupons() {

        // Stream, Method Reference 사용
        return couponRepository.findAll().stream().map(GetAllCouponsResDto::from).toList();

        /**
         *         [ 반복문 사용 ]
         *
         *         // repository 에서 전체 쿠폰 조회
         *         List<Coupon> couponList = couponRepository.findAll();
         *         // List 생성
         *         List<GetAllCouponsResDto> dtoList = new ArrayList<>();
         *         // dtoList -> couponList (향상된 for 문 사용)
         *         for (Coupon coupon : couponList) {
         *             dtoList.add(GetAllCouponsResDto.builder()
         *                             .couponUuid(coupon.getCouponUuid())
         *                             .name(coupon.getName())
         *                             .build());
         *         }
         *         return dtoList;
         */
        /**
         *         [ Stream, Lambda, 정적 팩토리 메서드 사용 ]
         *         return couponRepository.findAll().stream().map(coupon -> GetAllCouponsResDto.from(coupon)).toList();
         */
        /**
         *         [ Stream, Method Reference 사용 ]
         *         return couponRepository.findAll().stream().map(GetAllCouponsResDto::from).toList();
         */

    }
}
