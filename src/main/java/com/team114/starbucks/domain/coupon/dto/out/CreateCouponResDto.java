package com.team114.starbucks.domain.coupon.dto.out;

import com.team114.starbucks.domain.coupon.entity.Coupon;
import com.team114.starbucks.domain.coupon.enums.DiscountType;
import com.team114.starbucks.domain.coupon.vo.out.CreateCouponResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CreateCouponResDto {

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
    public CreateCouponResDto(
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

    // dto <- entity (정적  팩토리 메서드)
    public static CreateCouponResDto from(Coupon coupon) {
        return CreateCouponResDto.builder()
                .couponUuid(coupon.getCouponUuid())
                .couponName(coupon.getName())
                .couponDescription(coupon.getDescription())
                .discountType(coupon.getDiscountType())
                .discountValue(coupon.getDiscountValue())
                .minOrderPrice(coupon.getMinOrderPrice())
                .maxDiscountPrice(coupon.getMaxDiscountPrice())
                .validDays(coupon.getValidDays())
                .createdAt(coupon.getCreatedAt())
                .build();
    }

    // dto -> vo
    public CreateCouponResVo toVo() {
        return CreateCouponResVo.builder()
                .couponUuid(couponUuid)
                .couponName(couponName)
                .couponDescription(couponDescription)
                .discountType(discountType)
                .discountValue(discountValue)
                .minOrderPrice(minOrderPrice)
                .maxDiscountPrice(maxDiscountPrice)
                .validDays(validDays)
                .createdAt(createdAt)
                .build();
    }
}
