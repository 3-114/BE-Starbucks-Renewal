package com.team114.starbucks.domain.membercoupon.application;

import com.team114.starbucks.domain.membercoupon.dto.in.CreateIssueCouponReqDto;
import com.team114.starbucks.domain.membercoupon.dto.in.ConsumeCouponReqDto;
import com.team114.starbucks.domain.membercoupon.dto.out.GetAllMyCouponResDto;
import com.team114.starbucks.domain.membercoupon.enums.CouponViewFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberCouponService {

    void issueCoupon(String memberUuid, CreateIssueCouponReqDto createIssueCouponReqDto);

    void consumeCoupon(String memberUuid, ConsumeCouponReqDto useCouponReqDto);

    Page<GetAllMyCouponResDto> getMyCoupons(
            String memberUuid,
            CouponViewFilter status,
            Pageable pageable
    );
}
