package com.team114.starbucks.domain.color.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateColorResVo {

    private String colorName;

    @Builder
    public CreateColorResVo(
            String colorName
    ) {
        this.colorName = colorName;
    }
}