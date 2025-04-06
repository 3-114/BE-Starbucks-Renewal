package com.team114.starbucks.domain.memberCoupon.dto.in;

import com.team114.starbucks.domain.memberCoupon.vo.in.ConsumeCouponReqVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ConsumeCouponReqDto {

    private String couponUuid;

    @Builder
    public ConsumeCouponReqDto(String couponUuid) {
        this.couponUuid = couponUuid;
    }

    // dto <- vo
    public static ConsumeCouponReqDto from(
            ConsumeCouponReqVo useCouponReqVo
    ) {
        return ConsumeCouponReqDto.builder()
                .couponUuid(useCouponReqVo.getCouponUuid())
                .build();
    }
}
