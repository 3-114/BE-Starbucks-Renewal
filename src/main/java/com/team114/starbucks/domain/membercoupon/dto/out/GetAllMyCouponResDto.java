package com.team114.starbucks.domain.membercoupon.dto.out;

import com.team114.starbucks.domain.coupon.enums.DiscountType;
import com.team114.starbucks.domain.membercoupon.entity.MemberCoupon;
import com.team114.starbucks.domain.membercoupon.enums.CouponStatus;
import com.team114.starbucks.domain.membercoupon.vo.out.GetAllMyCouponResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetAllMyCouponResDto {

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
    public GetAllMyCouponResDto(
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

    public static GetAllMyCouponResDto from(MemberCoupon memberCoupon) {
        return GetAllMyCouponResDto.builder()
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

    public static GetAllMyCouponResVo toVo(GetAllMyCouponResDto getAllMyCouponResDto) {
        return GetAllMyCouponResVo.builder()
                .couponUuid(getAllMyCouponResDto.couponUuid)
                .couponName(getAllMyCouponResDto.couponName)
                .discountType(getAllMyCouponResDto.discountType)
                .minOrderPrice(getAllMyCouponResDto.minOrderPrice)
                .maxDiscountPrice(getAllMyCouponResDto.maxDiscountPrice)
                .validDays(getAllMyCouponResDto.validDays)
                .couponStatus(getAllMyCouponResDto.couponStatus)
                .issuedAt(getAllMyCouponResDto.issuedAt)
                .expiredAt(getAllMyCouponResDto.expiredAt)
                .build();
    }
}
