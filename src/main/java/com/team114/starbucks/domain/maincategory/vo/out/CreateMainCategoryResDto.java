package com.team114.starbucks.domain.maincategory.vo.out;

import com.team114.starbucks.domain.maincategory.entity.MainCategory;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateMainCategoryResDto {

    private String mainCategoryName;

    @Builder
    public CreateMainCategoryResDto(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

    public static CreateMainCategoryResDto from(MainCategory savedMainCategory) {
        return CreateMainCategoryResDto.builder()
                .mainCategoryName(savedMainCategory.getMainCategoryName())
                .build();
    }

    public CreateMainCategoryResVo toVo() {

        return CreateMainCategoryResVo.builder()
                .mainCategoryName(mainCategoryName)
                .build();
    }
}
