package com.team114.starbucks.domain.subcategory.dto.in;

import com.team114.starbucks.domain.subcategory.vo.in.UpdateSubCategoryReqVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateSubCategoryReqDtoTmp {

    private String mainCategoryUuid;
    private String subCategoryName;

    public static UpdateSubCategoryReqDtoTmp from(UpdateSubCategoryReqVo updateSubCategoryReqVo) {
        return UpdateSubCategoryReqDtoTmp.builder()
                .mainCategoryUuid(updateSubCategoryReqVo.getMainCategoryUuid())
                .subCategoryName(updateSubCategoryReqVo.getSubCategoryName())
                .build();
    }
}
