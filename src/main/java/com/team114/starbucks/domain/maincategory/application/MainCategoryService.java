package com.team114.starbucks.domain.maincategory.application;

import com.team114.starbucks.domain.maincategory.dto.in.CreateMainCategoryReqDto;
import com.team114.starbucks.domain.maincategory.dto.in.UpdateMainCategoryReqDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetAllMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetNameAndImageResDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetMainCategoryResDto;

import java.util.List;

public interface MainCategoryService {

    List<GetAllMainCategoryResDto> getAllMainCategory();

    GetMainCategoryResDto getOneMainCategory(String mainCategoryUuid);

    void saveMainCategory(CreateMainCategoryReqDto createMainCategoryReqDto);

    void updateMainCategory(String mainCategoryUuid, UpdateMainCategoryReqDto updateMainCategoryReqDto);

    void deleteMainCategory(String mainCategoryUuid);

    List<GetNameAndImageResDto> getNameAndImage();

}
