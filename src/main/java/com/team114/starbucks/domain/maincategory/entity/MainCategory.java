package com.team114.starbucks.domain.maincategory.entity;

import jakarta.persistence.*;
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
}
