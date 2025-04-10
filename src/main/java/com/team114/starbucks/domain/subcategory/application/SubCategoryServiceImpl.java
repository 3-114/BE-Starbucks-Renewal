package com.team114.starbucks.domain.subcategory.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.subcategory.dto.in.CreateSubCategoryReqDto;
import com.team114.starbucks.domain.subcategory.dto.out.GetAllSubCategoryResDto;
import com.team114.starbucks.domain.subcategory.entity.SubCategory;
import com.team114.starbucks.domain.subcategory.infrastructure.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    @Transactional
    @Override
    public void createSubCategory(CreateSubCategoryReqDto createSubCategoryReqDto) {
        try {
            SubCategory subCategory = createSubCategoryReqDto.toEntity(UUID.randomUUID().toString());

            SubCategory savedSubCategory = subCategoryRepository.save(subCategory);
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_FIND);
        }
    }



    @Override
    public List<GetAllSubCategoryResDto> getAllSubCategory() {
        List<SubCategory> subCategoryList = subCategoryRepository.findAll();
        List<GetAllSubCategoryResDto> subCategoryResDtoList = new ArrayList<>();

        for (SubCategory subCategory : subCategoryList) {
            subCategoryResDtoList.add(GetAllSubCategoryResDto.from(subCategory));
        }

        return subCategoryResDtoList;
    }
}
