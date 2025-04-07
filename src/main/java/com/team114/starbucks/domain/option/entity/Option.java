package com.team114.starbucks.domain.option.entity;

import com.team114.starbucks.common.entity.BaseEntity;
import com.team114.starbucks.domain.color.entity.Color;
import com.team114.starbucks.domain.size.entity.Size;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "product_option")
public class Option extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;

    @Column(nullable = false)
    private String productUuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id")
    private Size size;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Long optionPrice;

    @Column(nullable = false)
    private Integer discountRate;

    @Builder
    public Option(
            Long optionId,
            String productUuid,
            Color color,
            Size size,
            Integer stock,
            Long optionPrice,
            Integer discountRate
    ) {
        this.optionId = optionId;
        this.productUuid = productUuid;
        this.color = color;
        this.size = size;
        this.stock = stock;
        this.optionPrice = optionPrice;
        this.discountRate = discountRate;
    }

}
