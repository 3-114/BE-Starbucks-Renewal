package com.team114.starbucks.domain.coupon.dto.out;

import com.team114.starbucks.domain.coupon.entity.Coupon;
import com.team114.starbucks.domain.coupon.vo.out.GetAllCouponsResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllCouponsResDto {

    private String couponUuid;
    private String name;

    @Builder
    public GetAllCouponsResDto(String couponUuid, String name) {
        this.couponUuid = couponUuid;
        this.name = name;
    }

    public GetAllCouponsResVo toVo() {
        return GetAllCouponsResVo.builder()
                .couponUuid(couponUuid)
                .name(name)
                .build();
    }

    public static GetAllCouponsResDto from(Coupon coupon) {
        return GetAllCouponsResDto.builder()
                .couponUuid(coupon.getCouponUuid())
                .name(coupon.getName())
                .build();
    }
}
