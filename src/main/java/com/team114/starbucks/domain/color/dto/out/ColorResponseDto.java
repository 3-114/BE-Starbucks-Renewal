package com.team114.starbucks.domain.color.dto.out;

import com.team114.starbucks.domain.color.entity.Color;
import com.team114.starbucks.domain.color.vo.out.CreateColorResVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ColorResponseDto {
    private String colorName;

    @Builder
    public ColorResponseDto(
            String colorName
    ) {
        this.colorName = colorName;
    }

    public static ColorResponseDto from(Color color) {
        return ColorResponseDto.builder()
                .colorName(color.getColorName())
                .build();
    }

    public CreateColorResVo toVo() {
        return CreateColorResVo.builder()
                .colorName(colorName)
                .build();
    }
}
