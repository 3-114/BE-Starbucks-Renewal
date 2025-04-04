package com.team114.starbucks.domain.option.entity;

import com.team114.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Color extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colorId;

    @Column(nullable = false, length = 50)
    private String colorName;

    @Builder
    public Color(
            Long colorId,
            String colorName
    ) {
        this.colorId = colorId;
        this.colorName = colorName;
    }
}
