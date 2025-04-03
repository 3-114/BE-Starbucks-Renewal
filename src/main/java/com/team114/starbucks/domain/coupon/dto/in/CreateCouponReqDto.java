package com.team114.starbucks.domain.coupon.dto.in;

import com.team114.starbucks.domain.coupon.entity.Coupon;
import com.team114.starbucks.domain.coupon.enums.DiscountType;
import com.team114.starbucks.domain.coupon.vo.in.CreateCouponReqVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateCouponReqDto {

    private String couponName;
    private String couponDescription;
    private DiscountType discountType;
    private Integer discountValue;
    private Integer minOrderPrice;
    private Integer maxDiscountPrice;

    @Builder
    public CreateCouponReqDto(
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
    public static CreateCouponReqDto from(
            CreateCouponReqVo createCouponReqVo
    ) {
        return CreateCouponReqDto.builder()
                .couponName(createCouponReqVo.getCouponName())
                .couponDescription(createCouponReqVo.getCouponDescription())
                .discountType(createCouponReqVo.getDiscountType())
                .discountValue(createCouponReqVo.getDiscountValue())
                .minOrderPrice(createCouponReqVo.getMinOrderPrice())
                .maxDiscountPrice(createCouponReqVo.getMaxDiscountPrice())
                .build();
    }

    // dto -> entity
    public Coupon toEntity(String couponUuid) {

        return Coupon.builder()
                .couponUuid(couponUuid)
                .name(couponName)
                .description(couponDescription)
                .discountType(discountType)
                .discountValue(discountValue)
                .minOrderPrice(minOrderPrice)
                .maxDiscountPrice(maxDiscountPrice)
                .build();
    }
}
