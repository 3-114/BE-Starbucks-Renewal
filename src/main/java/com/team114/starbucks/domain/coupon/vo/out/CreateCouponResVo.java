package com.team114.starbucks.domain.coupon.vo.out;

import com.team114.starbucks.domain.coupon.enums.DiscountType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateCouponResVo {

    private String couponUuid;
    private String couponName;
    private String couponDescription;
    private DiscountType discountType;
    private Integer discountValue;
    private Integer minOrderPrice;
    private Integer maxDiscountPrice;
    private Long validDays;
    private LocalDateTime createdAt;

    @Builder
    public CreateCouponResVo(
            String couponUuid,
            String couponName,
            String couponDescription,
            DiscountType discountType,
            Integer discountValue,
            Integer minOrderPrice,
            Integer maxDiscountPrice,
            Long validDays,
            LocalDateTime createdAt
    ) {
        this.couponUuid = couponUuid;
        this.couponName = couponName;
        this.couponDescription = couponDescription;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.minOrderPrice = minOrderPrice;
        this.maxDiscountPrice = maxDiscountPrice;
        this.validDays = validDays;
        this.createdAt = createdAt;
    }
}
