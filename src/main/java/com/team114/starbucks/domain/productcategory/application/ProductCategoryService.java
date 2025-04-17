package com.team114.starbucks.domain.productcategory.application;

import com.team114.starbucks.domain.productcategory.dto.in.CreateProductCategoryReqDto;
import com.team114.starbucks.domain.productcategory.dto.out.GetAllProductUuidResDto;

import java.util.List;

//@Service
public interface ProductCategoryService {

    void createProductCategory(CreateProductCategoryReqDto createProductCategoryReqDto);

    List<GetAllProductUuidResDto> getProductUuidsByEventUuid(String eventUuid);
}
