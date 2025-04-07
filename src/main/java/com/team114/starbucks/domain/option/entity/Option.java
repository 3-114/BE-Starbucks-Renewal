package com.team114.starbucks.domain.option.entity;

import com.team114.starbucks.common.entity.BaseEntity;
import com.team114.starbucks.domain.color.entity.Color;
import com.team114.starbucks.domain.size.entity.Size;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_option")
@Getter
@NoArgsConstructor
public class Option extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer optionId;

    @Column(nullable = false)
    private String productUuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id", nullable = false)
    private Size size;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Integer optionPrice;

    @Column(nullable = false)
    private Integer discountRate;

    @Builder
    public Option(
            String productUuid,
            Color color,
            Size size,
            Integer stock,
            Integer optionPrice,
            Integer discountRate
    ) {
        this.productUuid = productUuid;
        this.color = color;
        this.size = size;
        this.stock = stock;
        this.optionPrice = optionPrice;
        this.discountRate = discountRate;
    }

}
