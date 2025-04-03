package com.team114.starbucks.domain.coupon.dto.in;

import com.team114.starbucks.domain.coupon.enums.DiscountType;
import com.team114.starbucks.domain.coupon.vo.in.UpdateCouponReqVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateCouponReqDto {

    private String couponName;
    private String couponDescription;
    private DiscountType discountType;
    private Integer discountValue;
    private Integer minOrderPrice;
    private Integer maxDiscountPrice;

    @Builder
    public UpdateCouponReqDto(
            String couponName,
            String couponDescription,
            DiscountType discountType,
            Integer discountValue,
            Integer minOrderPrice,
            Integer maxDiscountPrice
    ) {
        this.couponName = couponName;
        this.couponDescription = couponDescription;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.minOrderPrice = minOrderPrice;
        this.maxDiscountPrice = maxDiscountPrice;
    }

    // dto <- vo
    public static UpdateCouponReqDto from(
            UpdateCouponReqVo updateCouponReqVo
    ) {
        return UpdateCouponReqDto.builder()
                .couponName(updateCouponReqVo.getCouponName())
                .couponDescription(updateCouponReqVo.getCouponDescription())
                .discountType(updateCouponReqVo.getDiscountType())
                .discountValue(updateCouponReqVo.getDiscountValue())
                .minOrderPrice(updateCouponReqVo.getMinOrderPrice())
                .maxDiscountPrice(updateCouponReqVo.getMaxDiscountPrice())
                .build();
    }
}
