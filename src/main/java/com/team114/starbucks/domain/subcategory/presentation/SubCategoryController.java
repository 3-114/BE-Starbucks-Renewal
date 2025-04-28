package com.team114.starbucks.domain.subcategory.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.subcategory.application.SubCategoryService;
import com.team114.starbucks.domain.subcategory.dto.in.CreateSubCategoryReqDto;
import com.team114.starbucks.domain.subcategory.dto.in.UpdateSubCategoryReqDto;
import com.team114.starbucks.domain.subcategory.dto.out.GetAllSubCategoryResDto;
import com.team114.starbucks.domain.subcategory.dto.out.GetSubCategoryResDto;
import com.team114.starbucks.domain.subcategory.vo.in.CreateSubCategoryReqVo;
import com.team114.starbucks.domain.subcategory.vo.in.UpdateSubCategoryReqVo;
import com.team114.starbucks.domain.subcategory.vo.out.GetAllSubCategoryResVo;
import com.team114.starbucks.domain.subcategory.vo.out.GetSubCategoryResVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 1. 서브 카테고리 생성
     *
     * @param createSubCategoryReqVo 서브 카테고리 데이터
     * @return {@link BaseResponseEntity} 서브 카테고리 생성 결과
     */
    @Operation(summary = "서브 카테고리 생성", tags = {"sub-category"})
    @PostMapping
    public BaseResponseEntity<Void> createSubCategory(
            @RequestBody CreateSubCategoryReqVo createSubCategoryReqVo
    ) {
        subCategoryService.createSubCategory(CreateSubCategoryReqDto.from(createSubCategoryReqVo));

        return new BaseResponseEntity<>("서브 카테고리 생성에 성공했습니다. ", null);
    }

    /**
     * 2. 서브 카테고리 전체 조회
     *
     * @return {@link BaseResponseEntity} 서브 카테고리 전체 조회 결과
     */
    @Operation(summary = "서브 카테고리 전체 조회", tags = {"sub-category"})
    @GetMapping
    public BaseResponseEntity<List<GetAllSubCategoryResVo>> getAllSubCategory() {
        List<GetAllSubCategoryResDto> getAllSubCategoryResDtoList = subCategoryService.getAllSubCategory();
        List<GetAllSubCategoryResVo> getAllSubCategoryResVoList = new ArrayList<>();

        for (GetAllSubCategoryResDto getAllSubCategoryResDto : getAllSubCategoryResDtoList) {
            getAllSubCategoryResVoList.add(getAllSubCategoryResDto.toVo());
        }

        return new BaseResponseEntity<>("서브 카테고리 전체 조회에 성공했습니다. ", getAllSubCategoryResVoList);
    }

    /**
     * 3. 서브 카테고리 단건 조회
     *
     * @param subCategoryUuid 서브 카테고리 UUID
     * @return {@link BaseResponseEntity} 서브 카테고리 단건 조회 결과
     */
    @Operation(summary = "서브 카테고리 단건 조회", tags = {"sub-category"})
    @GetMapping("/{subCategoryUuid}")
    public BaseResponseEntity<GetSubCategoryResVo> getOneSubCategory(
            @PathVariable String subCategoryUuid) {
        GetSubCategoryResDto getSubCategoryResDto = subCategoryService.getOneSubCategory(subCategoryUuid);

        return new BaseResponseEntity<>("서브 카테고리 단건 조회에 성공했습니다. ", getSubCategoryResDto.toVo());

    }

    /**
     * 4. 서브 카테고리 수정
     *
     * @param subCategoryUuid 서브 카테고리 UUID
     * @param updateSubCategoryReqVo 서브 카테고리 수정 데이터
     * @return {@link BaseResponseEntity} 서브 카테고리 수정 결과
     */
    @Operation(summary = "서브 카테고리 수정", tags = {"sub-category"})
    @PutMapping("/{subCategoryUuid}")
    public BaseResponseEntity<Void> updateSubCategory(
            @PathVariable String subCategoryUuid,
            @RequestBody UpdateSubCategoryReqVo updateSubCategoryReqVo
    ) {
        subCategoryService.updateSubCategory(subCategoryUuid, UpdateSubCategoryReqDto.from(updateSubCategoryReqVo));

        return new BaseResponseEntity<>("서브 카테고리 수정에 성공했습니다. ", null);
    }

    /**
     * 4. 서브 카테고리 삭제
     *
     * @param subCategoryUuid 서브 카테고리 UUID
     * @return {@link BaseResponseEntity} 서브 카테고리 삭제 결과
     */
    @Operation(summary = "서브 카테고리 삭제", tags = {"sub-category"})
    @DeleteMapping("/{subCategoryUuid}")
    public BaseResponseEntity<Void> deleteSubCategory(
            @PathVariable String subCategoryUuid
    ) {
        subCategoryService.deleteSubCategory(subCategoryUuid);
        return new BaseResponseEntity<>("서브 카테고리 삭제에 성공했습니다. ", null);
    }

}