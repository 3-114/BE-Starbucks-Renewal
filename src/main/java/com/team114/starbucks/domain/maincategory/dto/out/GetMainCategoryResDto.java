package com.team114.starbucks.domain.maincategory.dto.out;

import com.team114.starbucks.domain.maincategory.entity.MainCategory;
import com.team114.starbucks.domain.maincategory.vo.out.GetMainCategoryResVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetMainCategoryResDto {

    private String mainCategoryName;

    @Builder
    public GetMainCategoryResDto(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

    public static GetMainCategoryResDto from(MainCategory mainCategory) {
        return GetMainCategoryResDto.builder()
                .mainCategoryName(mainCategory.getMainCategoryName())
                .build();
    }


    public GetMainCategoryResVo toVo() {
        return GetMainCategoryResVo.builder()
                .mainCategoryName(mainCategoryName)
                .build();
    }
}
