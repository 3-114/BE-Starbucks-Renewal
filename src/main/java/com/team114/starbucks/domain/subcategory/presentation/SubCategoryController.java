package com.team114.starbucks.domain.subcategory.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.subcategory.application.SubCategoryService;
import com.team114.starbucks.domain.subcategory.dto.in.CreateSubCategoryReqDto;
import com.team114.starbucks.domain.subcategory.dto.in.UpdateSubCategoryReqDto;
import com.team114.starbucks.domain.subcategory.dto.out.GetAllSubCategoryResDto;
import com.team114.starbucks.domain.subcategory.dto.out.GetOneSubCategoryResDto;
import com.team114.starbucks.domain.subcategory.vo.in.CreateSubCategoryReqVo;
import com.team114.starbucks.domain.subcategory.vo.in.UpdateSubCategoryReqVo;
import com.team114.starbucks.domain.subcategory.vo.out.GetAllSubCategoryResVo;
import com.team114.starbucks.domain.subcategory.vo.out.GetOneSubCategoryResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sub-category")
public class SubCategoryController {

    /*
     * 1. 서브 카테고리 생성
     * 2. 서브 카테고리 전체 조회
     * 3. 서브 카테고리 단건 조회
     * 4. 서브 카테고리 수정
     * 5. 서브 카테고리 삭제
     *  */

    private final SubCategoryService subCategoryService;

    // 1. 서브 카테고리 생성
    @PostMapping
    public BaseResponseEntity<Void> createSubCategory(
            @RequestBody CreateSubCategoryReqVo createSubCategoryReqVo
    ) {
        subCategoryService.createSubCategory(CreateSubCategoryReqDto.from(createSubCategoryReqVo));

        return new BaseResponseEntity<>("서브 카테고리 생성에 성공했습니다. ", null);
    }

    // 2. 서브 카테고리 전체 조회
    @GetMapping
    public BaseResponseEntity<List<GetAllSubCategoryResVo>> getAllSubCategory() {
        List<GetAllSubCategoryResDto> getAllSubCategoryResDtoList = subCategoryService.getAllSubCategory();
        List<GetAllSubCategoryResVo> getAllSubCategoryResVoList = new ArrayList<>();

        for (GetAllSubCategoryResDto getAllSubCategoryResDto : getAllSubCategoryResDtoList) {
            getAllSubCategoryResVoList.add(getAllSubCategoryResDto.toVo());
        }

        return new BaseResponseEntity<>("서브 카테고리 전체 조회에 성공했습니다. ", getAllSubCategoryResVoList);
    }

    // 3. 서브 카테고리 단건 조회 API
    @GetMapping("/{subCategoryUuid}")
    public BaseResponseEntity<GetOneSubCategoryResVo> getOneSubCategory(
            @PathVariable String subCategoryUuid) {
        GetOneSubCategoryResDto getOneSubCategoryResDto = subCategoryService.getOneSubCategory(subCategoryUuid);

        return new BaseResponseEntity<>("서브 카테고리 단건 조회에 성공했습니다. ", getOneSubCategoryResDto.toVo());

    }

    // 4. 서브 카테고리 수정
    @PutMapping("/{subCategoryUuid}")
    public BaseResponseEntity<Void> updateSubCategory(
            @PathVariable String subCategoryUuid,
            @RequestBody UpdateSubCategoryReqVo updateSubCategoryReqVo
    ) {
        subCategoryService.updateSubCategory(subCategoryUuid, UpdateSubCategoryReqDto.from(updateSubCategoryReqVo));

        return new BaseResponseEntity<>("서브 카테고리 수정에 성공했습니다. ", null);

    }
}
