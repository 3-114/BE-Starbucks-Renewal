package com.team114.starbucks.domain.coupon.vo.out;

import com.team114.starbucks.domain.coupon.enums.DiscountType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetCouponResVo {

    private String couponUuid;
    private String couponName;
    private String couponDescription;
    private DiscountType discountType;
    private Integer discountValue;
    private Integer minOrderPrice;
    private Integer maxDiscountPrice;
    private Long validDays;

    @Builder
    public GetCouponResVo(
            String couponUuid,
            String couponName,
            String couponDescription,
            DiscountType discountType,
            Integer discountValue,
            Integer minOrderPrice,
            Integer maxDiscountPrice,
            Long validDays
    ) {
        this.couponUuid = couponUuid;
        this.couponName = couponName;
        this.couponDescription = couponDescription;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.minOrderPrice = minOrderPrice;
        this.maxDiscountPrice = maxDiscountPrice;
        this.validDays = validDays;
    }
}
