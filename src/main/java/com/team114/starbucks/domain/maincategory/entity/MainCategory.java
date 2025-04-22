package com.team114.starbucks.domain.maincategory.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class MainCategory {

    // 메인 카테고리 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 메인 카테고리 UUID
    @Column(nullable = false, length = 50)
    private String mainCategoryUuid;

    // 메인 카테고리 명
    @Column(nullable = false, length = 100)
    private String mainCategoryName;

    // 메인 카테고리 이미지 URL
    @Column(nullable = false)
    private String mainCategoryImage;

    @Builder
    public MainCategory(Long id, String mainCategoryUuid, String mainCategoryName, String mainCategoryImage) {
        this.id = id;
        this.mainCategoryUuid = mainCategoryUuid;
        this.mainCategoryName = mainCategoryName;
        this.mainCategoryImage = mainCategoryImage;
    }
}
