package com.team114.starbucks.domain.maincategory.application;

import com.team114.starbucks.domain.maincategory.dto.in.CreateMainCategoryReqDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetAllMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetOneMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.vo.out.CreateMainCategoryResDto;

import java.util.List;

public interface MainCategoryService {
    List<GetAllMainCategoryResDto> getAllMainCategory();

    GetOneMainCategoryResDto getOneMainCategory(String mainCategoryUuid);

    CreateMainCategoryResDto saveMainCategory(CreateMainCategoryReqDto createMainCategoryReqDto);
}
