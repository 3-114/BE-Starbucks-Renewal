package com.team114.starbucks.domain.product.entity;


import com.team114.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class ProductThumbnail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private String thumbnailUrl;

    private String productUuid;

    // 상품 썸네일 이미지 순서
    @Column(nullable = false)
    private Integer thumbnailIndex;

    // 썸네일 여부
    private Boolean isThumbnail;

    // 이미지 업로드 시간
    private LocalDateTime updatedAt;
    // 등록자 정보
    private String uploadedBy;

    @Builder
    public ProductThumbnail(
            Long id,
            Product product,
            String thumbnailUrl,
            Integer thumbnailIndex,
            Boolean isThumbnail,
            LocalDateTime updatedAt,
            String uploadedBy,
            String productUuid
    ) {
        this.id = id;
        this.product = product;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailIndex = thumbnailIndex;
        this.isThumbnail = isThumbnail;
        this.updatedAt = updatedAt;
        this.uploadedBy = uploadedBy;
        this.productUuid = productUuid;
    }







}
