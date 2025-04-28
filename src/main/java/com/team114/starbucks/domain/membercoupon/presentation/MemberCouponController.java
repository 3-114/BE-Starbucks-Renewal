package com.team114.starbucks.domain.membercoupon.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.membercoupon.application.MemberCouponService;
import com.team114.starbucks.domain.membercoupon.dto.in.CreateIssueCouponReqDto;
import com.team114.starbucks.domain.membercoupon.dto.in.ConsumeCouponReqDto;
import com.team114.starbucks.domain.membercoupon.dto.out.GetAllMyCouponResDto;
import com.team114.starbucks.domain.membercoupon.enums.CouponViewFilter;
import com.team114.starbucks.domain.membercoupon.vo.in.CreateIssueCouponReqVo;
import com.team114.starbucks.domain.membercoupon.vo.in.ConsumeCouponReqVo;
import com.team114.starbucks.domain.membercoupon.vo.out.GetAllMyCouponResVo;
import io.swagger.v3.oas.annotations.Operation;
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
     * 1. 쿠폰 받기 (쿠폰 발행하기)
     * 2. 쿠폰 사용하기
     * 3. 내 쿠폰 조회
     */

    /**
     * 1. 쿠폰 받기
     * @param memberUuid 멤버 UUID
     * @param createIssueCouponReqVo 요청 쿠폰 데이터
     * @return {@link BaseResponseEntity} 쿠폰 받기 결과
     */
    @Operation(summary = "쿠폰 받기", tags = {"Coupon"})
    @PostMapping("/issue")
    public BaseResponseEntity<Void> issueCoupon(
            // X- 접두사로 커스텀 헤더임을 명시적으로 표시
            @RequestHeader("X-Member-UUID") String memberUuid,
            @RequestBody CreateIssueCouponReqVo createIssueCouponReqVo
    ) {
        memberCouponService.issueCoupon(memberUuid, CreateIssueCouponReqDto.from(createIssueCouponReqVo));
        return new BaseResponseEntity<>("쿠폰이 발행되었습니다.");
    }

    /**
     * 2. 쿠폰 사용하기
     * @param memberUuid 멤버 UUID
     * @param useCouponReqVo 쿠폰 UUID
     * @return {@link BaseResponseEntity} 쿠폰 사용하기 결과
     */
    @Operation(summary = "쿠폰 사용하기", tags = {"Coupon"})
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
     * @param memberUuid 멤버 UUID
     * @param status 상태
     * @param pageable 페이지
     * @return {@link BaseResponseEntity} 쿠폰 조회 결과
     */
    @Operation(summary = "내 쿠폰 조회", tags = {"Coupon"})
    @GetMapping
    public BaseResponseEntity<Page<GetAllMyCouponResVo>> getMyCoupons(
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
        Page<GetAllMyCouponResVo> result =  memberCouponService.getMyCoupons(memberUuid, status, pageable)
                .map(GetAllMyCouponResDto::toVo);

        return new BaseResponseEntity<>("내 쿠폰 페이지 조회에 성공하였습니다.", result);
    }

}