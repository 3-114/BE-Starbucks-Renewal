package com.team114.starbucks.domain.subcategory.dto.in;

import com.team114.starbucks.domain.subcategory.entity.SubCategory;
import com.team114.starbucks.domain.subcategory.vo.in.CreateSubCategoryReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateSubCategoryReqDto {

    private String mainCategoryUuid;
    private String subCategoryName;

    @Builder
    public CreateSubCategoryReqDto(String mainCategoryUuid, String subCategoryName) {
        this.mainCategoryUuid = mainCategoryUuid;
        this.subCategoryName = subCategoryName;
    }

    public static CreateSubCategoryReqDto from(CreateSubCategoryReqVo createSubCategoryReqVo) {
        return CreateSubCategoryReqDto.builder()
                .mainCategoryUuid(createSubCategoryReqVo.getMainCategoryUuid())
                .subCategoryName(createSubCategoryReqVo.getSubCategoryName())
                .build();
    }

    public SubCategory toEntity(String subCategoryUuid) {
        return SubCategory.builder()
                .mainCategoryUuid(mainCategoryUuid)
                .subCategoryUuid(subCategoryUuid)
                .subCategoryName(subCategoryName)
                .build();
    }

}