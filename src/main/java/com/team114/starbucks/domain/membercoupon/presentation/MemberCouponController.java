package com.team114.starbucks.domain.membercoupon.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.membercoupon.application.MemberCouponService;
import com.team114.starbucks.domain.membercoupon.dto.in.IssueCouponReqDto;
import com.team114.starbucks.domain.membercoupon.dto.in.ConsumeCouponReqDto;
import com.team114.starbucks.domain.membercoupon.dto.out.MyCouponResDto;
import com.team114.starbucks.domain.membercoupon.enums.CouponViewFilter;
import com.team114.starbucks.domain.membercoupon.vo.in.IssueCouponReqVo;
import com.team114.starbucks.domain.membercoupon.vo.in.ConsumeCouponReqVo;
import com.team114.starbucks.domain.membercoupon.vo.out.MyCouponResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/my-coupons")
public class MemberCouponController {

    private final MemberCouponService memberCouponService;

    /**
     * /api/v1/my-coupons
     * 1. 쿠폰 받기 (쿠폰 발행하기)
     * 2. 쿠폰 사용하기
     * 3. 내 쿠폰 조회
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
        memberCouponService.issueCoupon(memberUuid, IssueCouponReqDto.from(issueCouponReqVo));
        return new BaseResponseEntity<>("쿠폰이 발행되었습니다.");
    }

    /**
     * 2. 쿠폰 사용하기
     * @param
     * @return
     * @throws
     */
    @PutMapping("/consume")
    public BaseResponseEntity<Void> consumeCoupon(
            // X- 접두사로 커스텀 헤더임을 명시적으로 표시
            @RequestHeader("X-Member-UUID") String memberUuid,    // member UUID
            @RequestBody ConsumeCouponReqVo useCouponReqVo            // Coupon UUID
    ) {
        memberCouponService.consumeCoupon(memberUuid, ConsumeCouponReqDto.from(useCouponReqVo));
        return new BaseResponseEntity<>("쿠폰이 사용 되었습니다.");
    }

    /**
     * 3. 내 쿠폰 조회
     * @param memberUuid, status, pageable
     * @return Page<MyCouponResVo>
     * @throws
     */
    @GetMapping
    public BaseResponseEntity<Page<MyCouponResVo>> getMyCoupons(
            @RequestHeader("X-Member-UUID") String memberUuid,
            @RequestParam(
                    value = "status",
                    defaultValue = "AVAILABLE"
            ) CouponViewFilter status,
            @PageableDefault(
                    page = 0,                           // 기본 페이지 번호 : 0부터 시작, 첫 페이지
                    size = 10,                          // 한 페이지당 항목 수 : 기본 10개씩 조회
                    sort = "issuedAt",                  // 정렬 기준 컬럼 : 발급 일자 (issuedAt)
                    direction = Sort.Direction.DESC     // 정렬 방향 : 최신순 (내림차순)
            ) Pageable pageable
    ) {
        Page<MyCouponResVo> result =  memberCouponService.getMyCoupons(memberUuid, status, pageable)
                .map(MyCouponResDto::toVo);

        return new BaseResponseEntity<>("내 쿠폰 페이지 조회에 성공하였습니다.", result);
    }
}
