package com.team114.starbucks.domain.membercoupon.dto.in;

import com.team114.starbucks.domain.membercoupon.vo.in.IssueCouponReqVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class IssueCouponReqDto {

    private String couponUuid;

    @Builder
    public IssueCouponReqDto(String couponUuid) {
        this.couponUuid = couponUuid;
    }

    // dto <- vo
    public static IssueCouponReqDto from(
            IssueCouponReqVo issueCouponReqVo
    ) {
        return IssueCouponReqDto.builder()
                .couponUuid(issueCouponReqVo.getCouponUuid())
                .build();
    }
}
