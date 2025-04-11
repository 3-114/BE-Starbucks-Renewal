package com.team114.starbucks.domain.subcategory.dto.in;

import com.team114.starbucks.domain.subcategory.vo.in.UpdateSubCategoryReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateSubCategoryReqDto {

    private String mainCategoryUuid;
    private String subCategoryName;

    @Builder
    public UpdateSubCategoryReqDto(String mainCategoryUuid, String subCategoryName) {
        this.mainCategoryUuid = mainCategoryUuid;
        this.subCategoryName = subCategoryName;
    }

    public static UpdateSubCategoryReqDto from(UpdateSubCategoryReqVo updateSubCategoryReqVo) {
        return UpdateSubCategoryReqDto.builder()
                .mainCategoryUuid(updateSubCategoryReqVo.getMainCategoryUuid())
                .subCategoryName(updateSubCategoryReqVo.getSubCategoryName())
                .build();
    }
}
