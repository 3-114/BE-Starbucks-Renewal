package com.team114.starbucks.domain.subcategory.application;

import com.team114.starbucks.domain.subcategory.dto.in.CreateSubCategoryReqDto;
import org.springframework.stereotype.Service;

@Service
public interface SubCategoryService {
    void createSubCategory(CreateSubCategoryReqDto createSubCategoryReqDto);
}
