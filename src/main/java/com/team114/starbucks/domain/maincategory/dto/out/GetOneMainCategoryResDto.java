package com.team114.starbucks.domain.maincategory.dto.out;

import com.team114.starbucks.domain.maincategory.entity.MainCategory;
import com.team114.starbucks.domain.maincategory.vo.out.GetOneMainCategoryResVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetOneMainCategoryResDto {

    private String mainCategoryName;

    @Builder
    public GetOneMainCategoryResDto(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

    public static GetOneMainCategoryResDto from(MainCategory mainCategory) {
        return GetOneMainCategoryResDto.builder()
                .mainCategoryName(mainCategory.getMainCategoryName())
                .build();
    }


    public GetOneMainCategoryResVo toVo() {
        return GetOneMainCategoryResVo.builder()
                .mainCategoryName(mainCategoryName)
                .build();
    }
}
