package com.team114.starbucks.domain.coupon.dto.out;

import com.team114.starbucks.domain.coupon.entity.Coupon;
import com.team114.starbucks.domain.coupon.enums.DiscountType;
import com.team114.starbucks.domain.coupon.vo.out.GetCouponResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetCouponResDto {

    private String couponUuid;
    private String couponName;
    private String couponDescription;
    private DiscountType discountType;
    private Integer discountValue;
    private Integer minOrderPrice;
    private Integer maxDiscountPrice;
    private Long validDays;

    @Builder
    public GetCouponResDto(
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

    public static GetCouponResDto from(Coupon coupon) {
        return GetCouponResDto.builder()
                .couponUuid(coupon.getCouponUuid())
                .couponName(coupon.getName())
                .couponDescription(coupon.getDescription())
                .discountType(coupon.getDiscountType())
                .discountValue(coupon.getDiscountValue())
                .minOrderPrice(coupon.getMinOrderPrice())
                .maxDiscountPrice(coupon.getMaxDiscountPrice())
                .validDays(coupon.getValidDays())
                .build();
    }

    public GetCouponResVo toVo() {
        return GetCouponResVo.builder()
                .couponUuid(couponUuid)
                .couponName(couponName)
                .couponDescription(couponDescription)
                .discountType(discountType)
                .discountValue(discountValue)
                .minOrderPrice(minOrderPrice)
                .maxDiscountPrice(maxDiscountPrice)
                .validDays(validDays)
                .build();
    }
}
