package com.team114.starbucks.domain.memberCoupon.entity;

import com.team114.starbucks.common.entity.BaseEntity;
import com.team114.starbucks.domain.coupon.entity.Coupon;
import com.team114.starbucks.domain.memberCoupon.enums.CouponStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class MemberCoupon extends BaseEntity {

    // 유저 쿠폰 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 쿠폰
    // 지연로딩
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    // 멤버 UUID
    private String memberUuid;

    // 쿠폰 상태
    private CouponStatus couponStatus;

    // 발행 여부
    private Boolean issued;

    // 발행 일시
    private LocalDateTime issuedAt;

    // 만료 일시
    private LocalDateTime expiredAt;

    // 사용 여부
    private Boolean used;

    // 사용 일시
    private LocalDateTime usedAt;

    @Builder
    public MemberCoupon(
            Long id,
            Coupon coupon,
            String memberUuid,
            CouponStatus couponStatus,
            Boolean issued,
            LocalDateTime issuedAt,
            LocalDateTime expiredAt,
            Boolean used,
            LocalDateTime usedAt
    ) {
        this.id = id;
        this.coupon = coupon;
        this.memberUuid = memberUuid;
        this.couponStatus = couponStatus;
        this.issued = issued;
        this.issuedAt = issuedAt;
        this.expiredAt = expiredAt;
        this.used = used;
        this.usedAt = usedAt;
    }
}
