package com.team114.starbucks.domain.color.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ColorResponseVo {

    private String colorName;

    @Builder
    public ColorResponseVo(
            String colorName
    ) {
        this.colorName = colorName;
    }
}