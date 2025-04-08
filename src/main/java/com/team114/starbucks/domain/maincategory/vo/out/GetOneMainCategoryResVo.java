package com.team114.starbucks.domain.maincategory.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetOneMainCategoryResVo {

    private String mainCategoryName;

    @Builder
    public GetOneMainCategoryResVo(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }
}
