package com.team114.starbucks.domain.maincategory.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetNameAndImageResVo {

    private String mainCategoryUuid;
    private String mainCategoryName;
    private String mainCategoryImage;

    @Builder
    public GetNameAndImageResVo(String mainCategoryUuid, String mainCategoryName, String mainCategoryImage) {
        this.mainCategoryUuid = mainCategoryUuid;
        this.mainCategoryName = mainCategoryName;
        this.mainCategoryImage = mainCategoryImage;
    }

}