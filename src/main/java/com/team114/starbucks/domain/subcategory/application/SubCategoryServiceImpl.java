package com.team114.starbucks.domain.subcategory.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.subcategory.dto.in.CreateSubCategoryReqDto;
import com.team114.starbucks.domain.subcategory.dto.in.UpdateSubCategoryReqDto;
import com.team114.starbucks.domain.subcategory.dto.out.GetAllSubCategoryResDto;
import com.team114.starbucks.domain.subcategory.dto.out.GetOneSubCategoryResDto;
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

    /*
     * 1. 서브 카테고리 생성
     * 2. 서브 카테고리 전체 조회
     * 3. 서브 카테고리 단건 조회
     * 4. 서브 카테고리 수정
     * 5. 서브 카테고리 삭제
     *  */

    private final SubCategoryRepository subCategoryRepository;

    // 1. 서브 카테고리 생성
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

    // 2. 서브 카테고리 전체 조회
    @Override
    public List<GetAllSubCategoryResDto> getAllSubCategory() {
        List<SubCategory> subCategoryList = subCategoryRepository.findAll();
        List<GetAllSubCategoryResDto> subCategoryResDtoList = new ArrayList<>();

        for (SubCategory subCategory : subCategoryList) {
            subCategoryResDtoList.add(GetAllSubCategoryResDto.from(subCategory));
        }

        return subCategoryResDtoList;
    }

    // 3. 서브 카테고리 단건 조회
    @Override
    public GetOneSubCategoryResDto getOneSubCategory(String subCategoryUuid) {
        SubCategory subCategory = subCategoryRepository.findSubCategoryBySubCategoryUuid(subCategoryUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        return GetOneSubCategoryResDto.from(subCategory);

    }

    // 4. 서브 카테고리 수정
    @Transactional
    @Override
    public void updateSubCategory(String subCategoryUuid, UpdateSubCategoryReqDto updateSubCategoryReqDto) {
        SubCategory subCategory = subCategoryRepository.findSubCategoryBySubCategoryUuid(subCategoryUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        subCategory.update(updateSubCategoryReqDto.getMainCategoryUuid(), updateSubCategoryReqDto.getSubCategoryName());

    }

}
