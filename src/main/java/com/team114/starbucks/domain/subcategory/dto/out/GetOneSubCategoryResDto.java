package com.team114.starbucks.domain.subcategory.dto.out;

import com.team114.starbucks.domain.subcategory.entity.SubCategory;
import com.team114.starbucks.domain.subcategory.vo.out.GetOneSubCategoryResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetOneSubCategoryResDto {

    private String mainCategoryUuid;
    private String subCategoryUuid;
    private String subCategoryName;

    @Builder
    public GetOneSubCategoryResDto(String mainCategoryUuid, String subCategoryUuid, String subCategoryName) {
        this.mainCategoryUuid = mainCategoryUuid;
        this.subCategoryUuid = subCategoryUuid;
        this.subCategoryName = subCategoryName;
    }

    public static GetOneSubCategoryResDto from(SubCategory subCategory) {
        return GetOneSubCategoryResDto.builder()
                .mainCategoryUuid(subCategory.getMainCategoryUuid())
                .subCategoryUuid(subCategory.getSubCategoryUuid())
                .subCategoryName(subCategory.getSubCategoryName())
                .build();
    }

    public GetOneSubCategoryResVo toVo() {
        return GetOneSubCategoryResVo.builder()
                .mainCategoryUuid(mainCategoryUuid)
                .subCategoryUuid(subCategoryUuid)
                .subCategoryName(subCategoryName)
                .build();

    }
}
