package com.team114.starbucks.domain.maincategory.application;

import com.team114.starbucks.domain.maincategory.dto.out.GetAllMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetOneMainCategoryResDto;

import java.util.List;

public interface MainCategoryService {
    List<GetAllMainCategoryResDto> getAllMainCategory();

    GetOneMainCategoryResDto getOneMainCategory(String mainCategoryUuid);
}
