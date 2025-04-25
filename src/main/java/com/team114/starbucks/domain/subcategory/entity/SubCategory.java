package com.team114.starbucks.domain.subcategory.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class SubCategory {

    // 서브 카테고리 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 메인 카테고리 UUID
    @Column(nullable = false, length = 50)
    private String mainCategoryUuid;

    // 서브 카테고리 UUID
    @Column(nullable = false, length = 50)
    private String subCategoryUuid;

    // 서브 카테고리 이름
    @Column(nullable = false, length = 100)
    private String subCategoryName;

    @Builder
    public SubCategory(Long id, String mainCategoryUuid, String subCategoryUuid, String subCategoryName) {
        this.id = id;
        this.mainCategoryUuid = mainCategoryUuid;
        this.subCategoryUuid = subCategoryUuid;
        this.subCategoryName = subCategoryName;
    }

    public void update(String subCategoryUuidDto, String subCategoryNameDto) {
        this.subCategoryUuid = subCategoryUuidDto;
        this.subCategoryName = subCategoryNameDto;
    }
}
