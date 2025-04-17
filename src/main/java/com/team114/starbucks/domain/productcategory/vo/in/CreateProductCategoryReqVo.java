package com.team114.starbucks.domain.productcategory.vo.in;

import lombok.Getter;

@Getter
public class CreateProductCategoryReqVo {

    private String productUuid;
    private String mainCategoryUuid;
    private String subCategoryUuid;
    private String eventUuid;

}
