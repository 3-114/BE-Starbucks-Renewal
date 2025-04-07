package com.team114.starbucks.domain.maincategory.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetAllMainCategoryResVo {

    private String mainCategoryUuid;
    private String mainCategoryName;

    @Builder
    public GetAllMainCategoryResVo(String mainCategoryUuid, String mainCategoryName) {
        this.mainCategoryUuid = mainCategoryUuid;
        this.mainCategoryName = mainCategoryName;
    }
}
