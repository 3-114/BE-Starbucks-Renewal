package com.team114.starbucks.domain.coupon.dto.out;

import com.team114.starbucks.domain.coupon.entity.Coupon;
import com.team114.starbucks.domain.coupon.enums.DiscountType;
import com.team114.starbucks.domain.coupon.vo.out.UpdateCouponResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UpdateCouponResDto {

    private String couponName;
    private String couponDescription;
    private DiscountType discountType;
    private Integer discountValue;
    private Integer minOrderPrice;
    private Integer maxDiscountPrice;
    private Long validDays;
    private LocalDateTime updatedAt;

    @Builder
    public UpdateCouponResDto(
            String couponName,
            String couponDescription,
            DiscountType discountType,
            Integer discountValue,
            Integer minOrderPrice,
            Integer maxDiscountPrice,
            Long validDays,
            LocalDateTime updatedAt
    ) {
        this.couponName = couponName;
        this.couponDescription = couponDescription;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.minOrderPrice = minOrderPrice;
        this.maxDiscountPrice = maxDiscountPrice;
        this.validDays = validDays;
    }

    public static UpdateCouponResDto from(Coupon coupon) {
        return UpdateCouponResDto.builder()
                .couponName(coupon.getName())
                .couponDescription(coupon.getDescription())
                .discountType(coupon.getDiscountType())
                .discountValue(coupon.getDiscountValue())
                .minOrderPrice(coupon.getMinOrderPrice())
                .maxDiscountPrice(coupon.getMaxDiscountPrice())
                .validDays(coupon.getValidDays())
                .build();
    }

    public UpdateCouponResVo toVo() {
        return UpdateCouponResVo.builder()
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
