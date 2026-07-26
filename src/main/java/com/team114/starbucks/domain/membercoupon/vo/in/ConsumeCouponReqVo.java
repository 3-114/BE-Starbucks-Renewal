package com.team114.starbucks.domain.membercoupon.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ConsumeCouponReqVo {

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

    private String couponUuid;

    @Builder
    public ConsumeCouponReqVo(String couponUuid) {
        this.couponUuid = couponUuid;
    }

}