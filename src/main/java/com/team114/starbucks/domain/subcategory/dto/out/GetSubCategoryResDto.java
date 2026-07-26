package com.team114.starbucks.domain.subcategory.dto.out;

import com.team114.starbucks.domain.subcategory.entity.SubCategory;
import com.team114.starbucks.domain.subcategory.vo.out.GetSubCategoryResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetSubCategoryResDto {

    private String mainCategoryUuid;
    private String subCategoryUuid;
    private String subCategoryName;

    @Builder
    public GetSubCategoryResDto(String mainCategoryUuid, String subCategoryUuid, String subCategoryName) {
        this.mainCategoryUuid = mainCategoryUuid;
        this.subCategoryUuid = subCategoryUuid;
        this.subCategoryName = subCategoryName;
    }

    public static GetSubCategoryResDto from(SubCategory subCategory) {
        return GetSubCategoryResDto.builder()
                .mainCategoryUuid(subCategory.getMainCategoryUuid())
                .subCategoryUuid(subCategory.getSubCategoryUuid())
                .subCategoryName(subCategory.getSubCategoryName())
                .build();
    }

    public GetSubCategoryResVo toVo() {
        return GetSubCategoryResVo.builder()
                .mainCategoryUuid(mainCategoryUuid)
                .subCategoryUuid(subCategoryUuid)
                .subCategoryName(subCategoryName)
                .build();

    }
}
