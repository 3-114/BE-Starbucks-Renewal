package com.team114.starbucks.domain.coupon.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.coupon.dto.in.CreateCouponReqDto;
import com.team114.starbucks.domain.coupon.dto.in.UpdateCouponReqDto;
import com.team114.starbucks.domain.coupon.dto.out.CreateCouponResDto;
import com.team114.starbucks.domain.coupon.dto.out.GetAllCouponsResDto;
import com.team114.starbucks.domain.coupon.dto.out.GetCouponResDto;
import com.team114.starbucks.domain.coupon.dto.out.UpdateCouponResDto;
import com.team114.starbucks.domain.coupon.entity.Coupon;
import com.team114.starbucks.domain.coupon.infrastructure.CouponRepository;
import com.team114.starbucks.domain.coupon.vo.out.UpdateCouponResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * 3. 쿠폰 단건 조회 (uuid 로 조회)
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

    /**
     * 3. 쿠폰 단건 조회 (uuid 로 조회)
     * @param
     * @return GetCouponResDto
     * @throws
     */
    @Override
    public GetCouponResDto findCouponByUuid(String couponUuid) {

        // uuid 로 coupon 조회
        Coupon coupon = couponRepository.findByCouponUuid(couponUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        // entity -> dto
        return GetCouponResDto.from(coupon);
    }

    /**
     * 4. 쿠폰 정보 변경 (수정할 값만 변경, PUT 방식)
     * @param couponUuid, updateCouponReqDto
     * @return updateCouponResDto
     * @throws
     */
    @Override
    public UpdateCouponResDto updateCoupon(String couponUuid, UpdateCouponReqDto updateCouponReqDto) {

        // [1] uuid 로 coupon 조회
        Coupon coupon = couponRepository.findByCouponUuid(couponUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        // [2] 새로운 쿠폰 객체 생성 (삼항 연산자 사용)
        Coupon updatedCoupon = Coupon.builder()
                .id(coupon.getId())
                .couponUuid(coupon.getCouponUuid())
                .name(updateCouponReqDto.getCouponName() == null ? coupon.getName() : updateCouponReqDto.getCouponName())
                .description(updateCouponReqDto.getCouponDescription() == null ? coupon.getDescription() : updateCouponReqDto.getCouponDescription())
                .discountType(updateCouponReqDto.getDiscountType() == null ? coupon.getDiscountType() : updateCouponReqDto.getDiscountType())
                .discountValue(updateCouponReqDto.getDiscountValue() == null ? coupon.getDiscountValue() : updateCouponReqDto.getDiscountValue())
                .minOrderPrice(updateCouponReqDto.getMinOrderPrice() == null ? coupon.getMinOrderPrice() : updateCouponReqDto.getMinOrderPrice())
                .maxDiscountPrice(updateCouponReqDto.getMaxDiscountPrice() == null ? coupon.getMaxDiscountPrice() : updateCouponReqDto.getMaxDiscountPrice())
                .build();

        // [3] 업데이트된 coupon 으로 저장 (save)
        couponRepository.save(updatedCoupon);

        // [4] dto <- entity
        return UpdateCouponResDto.from(coupon);
    }
}
