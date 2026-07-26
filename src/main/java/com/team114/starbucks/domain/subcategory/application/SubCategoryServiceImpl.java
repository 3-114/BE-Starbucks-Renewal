package com.team114.starbucks.domain.subcategory.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.subcategory.dto.in.CreateSubCategoryReqDto;
import com.team114.starbucks.domain.subcategory.dto.in.UpdateSubCategoryReqDto;
import com.team114.starbucks.domain.subcategory.dto.out.GetAllSubCategoryResDto;
import com.team114.starbucks.domain.subcategory.dto.out.GetSubCategoryResDto;
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
@Transactional(readOnly = true)
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

    @Override
    public GetSubCategoryResDto getOneSubCategory(String subCategoryUuid) {
        SubCategory subCategory = subCategoryRepository.findSubCategoryBySubCategoryUuid(subCategoryUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        return GetSubCategoryResDto.from(subCategory);
    }

    @Transactional
    @Override
    public void updateSubCategory(String subCategoryUuid, UpdateSubCategoryReqDto updateSubCategoryReqDto) {
        SubCategory subCategory = subCategoryRepository.findSubCategoryBySubCategoryUuid(subCategoryUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );
        subCategory.update(updateSubCategoryReqDto.getMainCategoryUuid(),
                updateSubCategoryReqDto.getSubCategoryName());
    }

    @Transactional
    @Override
    public void deleteSubCategory(String subCategoryUuid) {
        SubCategory findSubCategory = subCategoryRepository.findSubCategoryBySubCategoryUuid(subCategoryUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        subCategoryRepository.delete(findSubCategory);
    }

}