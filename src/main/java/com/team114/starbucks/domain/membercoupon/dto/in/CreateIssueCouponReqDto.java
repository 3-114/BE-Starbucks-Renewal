package com.team114.starbucks.domain.membercoupon.dto.in;

import com.team114.starbucks.domain.membercoupon.vo.in.CreateIssueCouponReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateIssueCouponReqDto {

    private String couponUuid;

    @Builder
    public CreateIssueCouponReqDto(String couponUuid) {
        this.couponUuid = couponUuid;
    }

    public static CreateIssueCouponReqDto from(
            CreateIssueCouponReqVo createIssueCouponReqVo
    ) {
        return CreateIssueCouponReqDto.builder()
                .couponUuid(createIssueCouponReqVo.getCouponUuid())
                .build();
    }
}
