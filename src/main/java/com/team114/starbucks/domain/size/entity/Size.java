package com.team114.starbucks.domain.size.entity;

import com.team114.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Size extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sizeId;

    @Column(nullable = false, length = 50)
    private String sizeName;

    @Column(nullable = false, length = 20)
    private String capacity;

    @Builder
    public Size(Long sizeId,
                String sizeName,
                String capacity
    ) {
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.capacity = capacity;
    }
}
