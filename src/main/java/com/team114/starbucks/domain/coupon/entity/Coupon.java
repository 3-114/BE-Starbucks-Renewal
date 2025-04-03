package com.team114.starbucks.domain.coupon.entity;

import com.team114.starbucks.common.entity.BaseEntity;
import com.team114.starbucks.domain.coupon.enums.DiscountType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Coupon extends BaseEntity {

    // 쿠폰 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 쿠폰 UUID
    private String couponUuid;

    // 쿠폰명
    private String name;

    // 쿠폰 설명
    private String description;

    // 할인 방식 (정액 할인, 정률 할인)
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    // 할인 값
    private Integer discountValue;

    // 최소 주문 금액
    private Integer minOrderPrice;

    // 최대 할인 금액
    private Integer maxDiscountPrice;

    // 쿠폰 생성일
    private LocalDateTime createdAt;

    // 쿠폰 수정일
    private LocalDateTime updatedAt;

    @Builder
    public Coupon(
            Long id,
            String couponUuid,
            String name,
            String description,
            DiscountType discountType,
            Integer discountValue,
            Integer minOrderPrice,
            Integer maxDiscountPrice,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.couponUuid = couponUuid;
        this.name = name;
        this.description = description;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.minOrderPrice = minOrderPrice;
        this.maxDiscountPrice = maxDiscountPrice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
