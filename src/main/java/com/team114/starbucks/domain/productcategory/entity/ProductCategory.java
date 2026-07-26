package com.team114.starbucks.domain.productcategory.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(indexes = {
        @Index(name = "idx_main_category_uuid", columnList = "main_category_uuid")
})
public class ProductCategory {

    // 카테고리 항목 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCategoryId;

    // 상품 UUID
    @Column(nullable = false, length = 50)
    private String productUuid;

    // 메인 카테고리 UUID
    @Column(nullable = false, length = 50, unique = true)
    private String mainCategoryUuid;

    // 서브 카테고리 UUID
    @Column(nullable = false, length = 50)
    private String subCategoryUuid;

    // 이벤트 카테고리 UUID
    @Column(nullable = false, length = 50)
    private String eventUuid;

    @Builder
    public ProductCategory(Long productCategoryId, String productUuid, String mainCategoryUuid, String subCategoryUuid, String eventUuid) {
        this.productCategoryId = productCategoryId;
        this.productUuid = productUuid;
        this.mainCategoryUuid = mainCategoryUuid;
        this.subCategoryUuid = subCategoryUuid;
        this.eventUuid = eventUuid;
    }

}