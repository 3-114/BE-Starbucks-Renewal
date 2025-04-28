package com.team114.starbucks.domain.subcategory.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllSubCategoryResVo {

    private String mainCategoryUuid;
    private String subCategoryUuid;
    private String subCategoryName;

    @Builder
    public GetAllSubCategoryResVo(String mainCategoryUuid, String subCategoryUuid, String subCategoryName) {
        this.mainCategoryUuid = mainCategoryUuid;
        this.subCategoryUuid = subCategoryUuid;
        this.subCategoryName = subCategoryName;
    }

}