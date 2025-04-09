package com.team114.starbucks.domain.product.entity;

import com.team114.starbucks.common.entity.BaseEntity;
import com.team114.starbucks.domain.product.enums.Brand;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Entity
@Getter
@NoArgsConstructor
public class Product extends BaseEntity {
    // 상품 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 상품 UUID
    @Column(nullable = false, unique = true)
    private String productUuid;

    // 브랜드명 ENUM -> STRING으로 수정
    @Column(nullable = false)
    private String brand;

    // 상품명
    @Column(nullable = false)
    private String productName;

    // 가격
    @Column(nullable = false)
    private Integer productPrice;

    // 상품 만료기한
    private LocalDateTime expiredAt;

    // 상품 상태
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductStatus productStatus;

    // 기본 배송료
    @Column(nullable = false)
    private Integer shippingFee;

    // 상품 상세내역 이미지


    @Builder
    public Product(
            Long id,
            String productUuid,
            String brand,
            String productName,
            Integer productPrice,
            LocalDateTime expiredAt,
            ProductStatus productStatus,
            Integer shippingFee
    ) {
        this.id = id;
        this.productUuid = productUuid;
        this.brand = brand;
        this.productName = productName;
        this.productPrice = productPrice;
        this.expiredAt = expiredAt;
        this.productStatus = productStatus;
        this.shippingFee = shippingFee;
    }

}
