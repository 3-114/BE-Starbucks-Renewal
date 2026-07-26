package com.team114.starbucks.domain.maincategory.dto.out;

import com.team114.starbucks.domain.maincategory.entity.MainCategory;
import com.team114.starbucks.domain.maincategory.vo.out.GetAllMainCategoryResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllMainCategoryResDto {

    private String mainCategoryUuid;
    private String mainCategoryName;

    @Builder
    public GetAllMainCategoryResDto(String mainCategoryUuid, String mainCategoryName) {
        this.mainCategoryUuid = mainCategoryUuid;
        this.mainCategoryName = mainCategoryName;
    }

    public static GetAllMainCategoryResDto from(MainCategory mainCategory) {
        return GetAllMainCategoryResDto.builder()
                .mainCategoryUuid(mainCategory.getMainCategoryUuid())
                .mainCategoryName(mainCategory.getMainCategoryName())
                .build();
    }

    public GetAllMainCategoryResVo toVo() {
        return GetAllMainCategoryResVo.builder()
                .mainCategoryUuid(mainCategoryUuid)
                .mainCategoryName(mainCategoryName)
                .build();
    }
}
