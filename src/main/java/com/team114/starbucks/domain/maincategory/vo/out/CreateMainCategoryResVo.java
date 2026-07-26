package com.team114.starbucks.domain.maincategory.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateMainCategoryResVo {

    private String mainCategoryName;

    @Builder
    public CreateMainCategoryResVo(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

}
