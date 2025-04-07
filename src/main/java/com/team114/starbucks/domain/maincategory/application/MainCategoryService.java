package com.team114.starbucks.domain.maincategory.application;

import com.team114.starbucks.domain.maincategory.dto.out.GetAllMainCategoryResDto;

import java.util.List;

public interface MainCategoryService {
    List<GetAllMainCategoryResDto> getAllMainCategory();
}
