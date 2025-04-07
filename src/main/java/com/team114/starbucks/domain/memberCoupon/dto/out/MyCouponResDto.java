package com.team114.starbucks.domain.memberCoupon.dto.out;

import com.team114.starbucks.domain.coupon.enums.DiscountType;
import com.team114.starbucks.domain.memberCoupon.entity.MemberCoupon;
import com.team114.starbucks.domain.memberCoupon.enums.CouponStatus;
import com.team114.starbucks.domain.memberCoupon.vo.out.MyCouponResVo;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

@Getter
public class MyCouponResDto {

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
    public MyCouponResDto(
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

    // dto <- memberCoupon
    public static MyCouponResDto from(MemberCoupon memberCoupon) {

        return MyCouponResDto.builder()
                .couponUuid(memberCoupon.getCoupon().getCouponUuid())
                .couponName(memberCoupon.getCoupon().getName())
                .discountType(memberCoupon.getCoupon().getDiscountType())
                .minOrderPrice(memberCoupon.getCoupon().getMinOrderPrice())
                .maxDiscountPrice(memberCoupon.getCoupon().getMaxDiscountPrice())
                .validDays(memberCoupon.getCoupon().getValidDays())
                .couponStatus(memberCoupon.getCouponStatus())
                .issuedAt(memberCoupon.getIssuedAt())
                .expiredAt(memberCoupon.getExpiredAt())
                .build();
    }

    // dto -> vo
    public static MyCouponResVo toVo(MyCouponResDto myCouponResDto) {

        return MyCouponResVo.builder()
                .couponUuid(myCouponResDto.couponUuid)
                .couponName(myCouponResDto.couponName)
                .discountType(myCouponResDto.discountType)
                .minOrderPrice(myCouponResDto.minOrderPrice)
                .maxDiscountPrice(myCouponResDto.maxDiscountPrice)
                .validDays(myCouponResDto.validDays)
                .couponStatus(myCouponResDto.couponStatus)
                .issuedAt(myCouponResDto.issuedAt)
                .expiredAt(myCouponResDto.expiredAt)
                .build();
    }
}
