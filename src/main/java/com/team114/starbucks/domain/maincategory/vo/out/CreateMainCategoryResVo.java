package com.team114.starbucks.domain.maincategory.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateMainCategoryResVo {

    private String mainCategoryName;

    @Builder
    public CreateMainCategoryResVo(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }
}
