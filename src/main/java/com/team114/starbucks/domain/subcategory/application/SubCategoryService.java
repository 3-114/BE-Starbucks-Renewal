package com.team114.starbucks.domain.subcategory.application;

import com.team114.starbucks.domain.subcategory.dto.in.CreateSubCategoryReqDto;
import com.team114.starbucks.domain.subcategory.dto.out.GetAllSubCategoryResDto;
import com.team114.starbucks.domain.subcategory.dto.out.GetOneSubCategoryResDto;
import com.team114.starbucks.domain.subcategory.vo.out.GetOneSubCategoryResVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubCategoryService {
    void createSubCategory(CreateSubCategoryReqDto createSubCategoryReqDto);

    List<GetAllSubCategoryResDto> getAllSubCategory();

    GetOneSubCategoryResDto getOneSubCategory(String subCategoryUuid);
}
