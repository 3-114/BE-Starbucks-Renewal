package com.team114.starbucks.domain.product.entity;

import com.team114.starbucks.domain.product.enums.Brand;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Product {

    // 상품 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 상품 UUID
    private String uuid;

    // 브랜드명
    private Brand brand;

    // 상품명
    private String name;

    // 가격
    private Integer price;

    // 상품 상세내역
    private String description;

    // 상품 등록일
    private LocalDateTime createdAt;

    // 상품 만료기한
    private LocalDateTime expiredAt;

    // 상품 상태
    private ProductStatus productStatus;

    // 옵션 여부
    private Boolean optionFlag;

    // 기본 배송료
    private Integer shippingFee;

    @Builder
    public Product(
            Long id,
            String uuid,
            Brand brand,
            String name,
            Integer price,
            String description,
            LocalDateTime createdAt,
            LocalDateTime expiredAt,
            ProductStatus productStatus,
            Boolean optionFlag,
            Integer shippingFee
    ) {
        this.id = id;
        this.uuid = uuid;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.description = description;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.productStatus = productStatus;
        this.optionFlag = optionFlag;
        this.shippingFee = shippingFee;
    }
}
