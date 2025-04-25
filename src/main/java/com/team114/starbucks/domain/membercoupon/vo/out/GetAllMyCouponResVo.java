package com.team114.starbucks.domain.membercoupon.vo.out;

import com.team114.starbucks.domain.coupon.enums.DiscountType;
import com.team114.starbucks.domain.membercoupon.enums.CouponStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetAllMyCouponResVo {

    private String couponUuid;
    private String couponName;
    private DiscountType discountType;
    private Integer discountValue;
    private Integer minOrderPrice;
    private Integer maxDiscountPrice;
    private Long validDays;
    private CouponStatus couponStatus;
    private LocalDateTime issuedAt;
    private LocalDateTime expiredAt;

    @Builder
    public GetAllMyCouponResVo(
            String couponUuid,
            String couponName,
            DiscountType discountType,
            Integer discountValue,
            Integer minOrderPrice,
            Integer maxDiscountPrice,
            Long validDays,
            CouponStatus couponStatus,
            LocalDateTime issuedAt,
            LocalDateTime expiredAt
    ) {
        this.couponUuid = couponUuid;
        this.couponName = couponName;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.minOrderPrice = minOrderPrice;
        this.maxDiscountPrice = maxDiscountPrice;
        this.validDays = validDays;
        this.couponStatus = couponStatus;
        this.issuedAt = issuedAt;
        this.expiredAt = expiredAt;
    }

}