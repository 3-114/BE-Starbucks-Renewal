package com.team114.starbucks.domain.color.dto.in;

import com.team114.starbucks.domain.color.entity.Color;
import com.team114.starbucks.domain.color.vo.in.CreateColorReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ColorRequestDto {
    private String colorName;

    @Builder
    public ColorRequestDto(String colorName) {
        this.colorName = colorName;
    }

    public static ColorRequestDto from(
            CreateColorReqVo createColorReqVo
    ) {
        return ColorRequestDto.builder()
                .colorName(createColorReqVo.getColorName())
                .build();
    }

    public Color toEntity() {
        return Color.builder()
                .colorName(colorName)
                .build();
    }
}
