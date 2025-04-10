package com.team114.starbucks.domain.subcategory.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.subcategory.application.SubCategoryService;
import com.team114.starbucks.domain.subcategory.dto.in.CreateSubCategoryReqDto;
import com.team114.starbucks.domain.subcategory.vo.in.CreateSubCategoryReqVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sub-category")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    /*
     * 1. 서브 카테고리 생성
     * 2. 서브 카테고리 전체 조회
     * 3. 서브 카테고리 단건 조회
     * 4. 서브 카테고리 수정
     * 5. 서브 카테고리 삭제
     *  */

    // 1. 서브 카테고리 생성
    @PostMapping
    public BaseResponseEntity<Void> createSubCategory(
            @RequestBody CreateSubCategoryReqVo createSubCategoryReqVo
    ) {
        subCategoryService.createSubCategory(CreateSubCategoryReqDto.from(createSubCategoryReqVo));

        return new BaseResponseEntity<>("서브 카테고리 생성에 성공했습니다. ", null);
    }


}
