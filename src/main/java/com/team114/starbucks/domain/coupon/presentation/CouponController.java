package com.team114.starbucks.domain.coupon.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.coupon.application.CouponService;
import com.team114.starbucks.domain.coupon.dto.in.CreateCouponReqDto;
import com.team114.starbucks.domain.coupon.dto.in.UpdateCouponReqDto;
import com.team114.starbucks.domain.coupon.dto.out.GetAllCouponsResDto;
import com.team114.starbucks.domain.coupon.vo.in.CreateCouponReqVo;
import com.team114.starbucks.domain.coupon.vo.in.UpdateCouponReqVo;
import com.team114.starbucks.domain.coupon.vo.out.CreateCouponResVo;
import com.team114.starbucks.domain.coupon.vo.out.GetAllCouponsResVo;
import com.team114.starbucks.domain.coupon.vo.out.GetCouponResVo;
import com.team114.starbucks.domain.coupon.vo.out.UpdateCouponResVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/coupon")
public class CouponController {

    private final CouponService couponService;

    /**
     * 1. 쿠폰 생성
     * 2. 쿠폰 전체 조회
     * 3. 쿠폰 UUID -> 단건 조회
     * 4. 쿠폰 정보 변경
     * 5. 쿠폰 삭제
     */

    /**
     * 1. 쿠폰 생성
     *
     * @param createCouponReqVo 쿠폰생성 데이터
     * @return {@link BaseResponseEntity} 쿠폰생성 결과
     */
    @Operation(summary = "쿠폰 생성", tags = {"Coupon"})
    @PostMapping
    public BaseResponseEntity<CreateCouponResVo> createCoupon(
            @RequestBody CreateCouponReqVo createCouponReqVo
    ) {
        CreateCouponResVo result = couponService.saveCoupon(CreateCouponReqDto.from(createCouponReqVo)).toVo();
        return new BaseResponseEntity<>("쿠폰이 생성되었습니다.", result);
    }

    /**
     * 2. 쿠폰 전체 조회
     *
     * @return {@link BaseResponseEntity} 쿠폰 전체조회 결과
     */
    @Operation(summary = "쿠폰 전체 조회", tags = {"Coupon"})
    @GetMapping
    public BaseResponseEntity<List<GetAllCouponsResVo>> getAllCoupons() {

        List<GetAllCouponsResVo> result = couponService.findAllCoupons()
                .stream().map(GetAllCouponsResDto::toVo).toList();

        return new BaseResponseEntity<>("쿠폰 전체 조회에 성공하였습니다.", result);
    }

    /**
     * 3. 쿠폰 UUID -> 단건 조회
     *
     * @param couponUuid 쿠폰 UUID
     * @return {@link BaseResponseEntity} 쿠폰 단건조회 결과
     */
    @Operation(summary = "쿠폰 단건 조회", tags = {"Coupon"})
    @GetMapping("/{couponUuid}")
    public BaseResponseEntity<GetCouponResVo> getCoupon(
            @PathVariable String couponUuid
    ) {
        GetCouponResVo result = couponService.findCouponByUuid(couponUuid).toVo();
        return new BaseResponseEntity<>("쿠폰 단건 조회에 성공하였습니다.", result);
    }

    /**
     * 4. 쿠폰 정보 변경
     *
     * @param couponUuid 쿠폰 UUID
     * @param updateCouponReqVo 쿠폰 수정 데이터
     * @return {@link BaseResponseEntity} 쿠폰 수정 결과
     */
    @Operation(summary = "쿠폰 정보 변경", tags = {"Coupon"})
    @PutMapping("/{couponUuid}")
    public BaseResponseEntity<UpdateCouponResVo> updateCoupon(
            @PathVariable String couponUuid,
            @RequestBody UpdateCouponReqVo updateCouponReqVo
    ) {
        UpdateCouponResVo result = couponService.updateCoupon(
                couponUuid,
                UpdateCouponReqDto.from(updateCouponReqVo)
        ).toVo();
        return new BaseResponseEntity<>("쿠폰 정보를 변경하였습니다.", result);
    }

    /**
     * 5. 쿠폰 삭제
     *
     * @param couponUuid 쿠폰 UUID
     * @return {@link BaseResponseEntity} 쿠폰 삭제 결과
     */
    @Operation(summary = "쿠폰 삭제", tags = {"Coupon"})
    @DeleteMapping("/{couponUuid}")
    public BaseResponseEntity<Void> deleteCoupon(
            @PathVariable String couponUuid
    ) {
        couponService.deleteCoupon(couponUuid);
        return new BaseResponseEntity<>("쿠폰이 삭제되었습니다.", null);
    }
}
