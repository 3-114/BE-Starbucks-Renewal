package com.team114.starbucks.domain.productcategory.application;

import com.team114.starbucks.domain.productcategory.dto.in.CreateProductCategoryReqDto;
import org.springframework.stereotype.Service;

//@Service
public interface ProductCategoryService {

    void createProductCategory(CreateProductCategoryReqDto createProductCategoryReqDto);
}
