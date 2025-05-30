package com.team114.starbucks.domain.coupon.vo.in;

import com.team114.starbucks.domain.coupon.enums.DiscountType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateCouponReqVo {

    /**
     * [ Validation ]
     *
     * @NotNull : null 불가, 빈 문자열 허용, 공백 문자열 허용
     * @NotEmpty : null 불가, 빈 문자열 불가, 공백 문자열 허용
     * @NotBlank : null 불가, 빈 문자열 불가, 공백 문자열 불가
     * @Email : 이메일 형식 이어야 함.
     * @Min : 숫자 형식에만 사용 가능
     * @Max : 숫자 형식에만 사용 가능
     * @Size : 문자열 길이 제한
     * @Pattern : 패턴 지정
     */

    private String couponName;
    private String couponDescription;
    private DiscountType discountType;
    private Integer discountValue;
    private Integer minOrderPrice;
    private Integer maxDiscountPrice;
    private Long validDays;

    @Builder
    public UpdateCouponReqVo(
            String couponName,
            String couponDescription,
            DiscountType discountType,
            Integer discountValue,
            Integer minOrderPrice,
            Integer maxDiscountPrice,
            Long validDays
    ) {
        this.couponName = couponName;
        this.couponDescription = couponDescription;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.minOrderPrice = minOrderPrice;
        this.maxDiscountPrice = maxDiscountPrice;
        this.validDays = validDays;
    }
}
