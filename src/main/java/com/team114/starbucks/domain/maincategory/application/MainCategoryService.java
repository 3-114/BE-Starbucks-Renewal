package com.team114.starbucks.domain.maincategory.application;

import com.team114.starbucks.domain.maincategory.dto.in.CreateMainCategoryReqDto;
import com.team114.starbucks.domain.maincategory.dto.in.UpdateMainCategoryReqDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetAllMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetOneMainCategoryResDto;

import java.util.List;

public interface MainCategoryService {
    List<GetAllMainCategoryResDto> getAllMainCategory();

    GetOneMainCategoryResDto getOneMainCategory(String mainCategoryUuid);

    void saveMainCategory(CreateMainCategoryReqDto createMainCategoryReqDto);

    Void updateMainCategory(String mainCategoryUuid, UpdateMainCategoryReqDto updateMainCategoryReqDto);

    Void deleteMainCategory(String mainCategoryUuid);
}
