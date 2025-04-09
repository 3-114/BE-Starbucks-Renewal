package com.team114.starbucks.domain.color.dto.in;

import com.team114.starbucks.domain.color.entity.Color;
import com.team114.starbucks.domain.color.vo.in.ColorRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ColorRequestDto {
    private String colorName;

    @Builder
    public ColorRequestDto(String colorName) {
        this.colorName = colorName;
    }

    public static ColorRequestDto from(
            ColorRequestVo colorRequestVo
    ) {
        return ColorRequestDto.builder()
                .colorName(colorRequestVo.getColorName())
                .build();
    }

    public Color toEntity() {
        return Color.builder()
                .colorName(colorName)
                .build();
    }
}
