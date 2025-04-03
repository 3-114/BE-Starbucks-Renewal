package com.team114.starbucks.domain.coupon.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.coupon.application.CouponService;
import com.team114.starbucks.domain.coupon.dto.in.CreateCouponReqDto;
import com.team114.starbucks.domain.coupon.dto.out.GetAllCouponsResDto;
import com.team114.starbucks.domain.coupon.vo.in.CreateCouponReqVo;
import com.team114.starbucks.domain.coupon.vo.out.CreateCouponResVo;
import com.team114.starbucks.domain.coupon.vo.out.GetAllCouponsResVo;
import com.team114.starbucks.domain.coupon.vo.out.GetCouponResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/coupon")
public class CouponController {

    private final CouponService couponService;

    /**
     * api/v1/coupon
     * 1. 쿠폰 생성
     * 2. 쿠폰 전체 조회
     * 3. 쿠폰 UUID -> 단건 조회
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

    /**
     * 2. 쿠폰 전체 조회
     * @param
     * @return createCouponResVo
     * @throws
     */
    @GetMapping
    public BaseResponseEntity<List<GetAllCouponsResVo>> getAllCoupons() {

        // [ Stream, Method Reference 사용 ]
        List<GetAllCouponsResVo> result = couponService.findAllCoupons()
                .stream().map(GetAllCouponsResDto::toVo).toList();

        return new BaseResponseEntity<>("쿠폰 전체 조회에 성공하였습니다.", result);

        /**
         *         [ dto -> vo (반복문 사용) ]
         *
         *          List<GetAllCouponsResDto> dtolist = couponService.findAllCoupons();
         *
         *         List<GetAllCouponsResVo> voList = new ArrayList<>();
         *         for (GetAllCouponsResDto getAllCouponsResDto : dtolist) {
         *             voList.add(getAllCouponsResDto.toVo());
         *         }
         *         return new BaseResponseEntity<>("쿠폰 전체 조회에 성공하였습니다.", voList);
         */
        /**
         *         [ Stream, Method Reference 사용 ]
         *         List<GetAllCouponsResVo> result = couponService.findAllCoupons()
         *                 .stream().map(GetAllCouponsResDto::toVo).toList();
         *
         *         return new BaseResponseEntity<>("쿠폰 전체 조회에 성공하였습니다.", result);
         */

    }

    /**
     * 3. 쿠폰 UUID -> 단건 조회
     * @param
     * @return getCouponResVo
     * @throws
     */
    @GetMapping("/{couponUuid}")
    public BaseResponseEntity<GetCouponResVo> getCoupon(
            @PathVariable String couponUuid
    ) {
        GetCouponResVo result = couponService.findCouponByUuid(couponUuid).toVo();
        return new BaseResponseEntity<>("쿠폰 단건 조회에 성공하였습니다.", result);
    }

}
