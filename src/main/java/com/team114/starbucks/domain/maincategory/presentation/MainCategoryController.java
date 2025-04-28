package com.team114.starbucks.domain.maincategory.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.maincategory.application.MainCategoryService;
import com.team114.starbucks.domain.maincategory.dto.in.CreateMainCategoryReqDto;
import com.team114.starbucks.domain.maincategory.dto.in.UpdateMainCategoryReqDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetAllMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetNameAndImageResDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.vo.in.CreateMainCategoryReqVo;
import com.team114.starbucks.domain.maincategory.vo.in.UpdateMainCategoryReqVo;
import com.team114.starbucks.domain.maincategory.vo.out.GetAllMainCategoryResVo;
import com.team114.starbucks.domain.maincategory.vo.out.GetNameAndImageResVo;
import com.team114.starbucks.domain.maincategory.vo.out.GetMainCategoryResVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/main-category")
public class MainCategoryController {

    private final MainCategoryService mainCategoryService;

    /*
     * 1. 메인 카테고리 생성
     * 2. 메인 카테고리 전체 조회
     * 3. 메인 카테고리 단건 조회
     * 4. 메인 카테고리 수정
     * 5. 메인 카테고리 삭제
     * 6. 메인 카테고리 이름, 이미지 전체 조회
     *  */

    /**
     * 1. 메인 카테고리 생성
     *
     * @param createMainCategoryReqVo 메인 카테고리 생성 데이터
     * @return {@link BaseResponseEntity} 메인 카테고리 생성 결과
     */
    @Operation(summary = "메인 카테고리 생성", tags = {"main-category"})
    @PostMapping
    public BaseResponseEntity<Void> createMainCategory(
            @RequestBody CreateMainCategoryReqVo createMainCategoryReqVo
    ) {
        mainCategoryService.saveMainCategory(CreateMainCategoryReqDto.from(createMainCategoryReqVo));

        return new BaseResponseEntity<>("메인 카테고리 생성에 성공했습니다. ", null);
    }

    /**
     * 2. 메인 카테고리 전체 조회
     *
     * @return {@link BaseResponseEntity} 메인 카테고리 전체 조회 결과
     */
    @Operation(summary = "메인 카테고리 이름 전체 조회", tags = {"main-category"})
    @GetMapping
    public BaseResponseEntity<List<GetAllMainCategoryResVo>> getAllMainCategory() {
        List<GetAllMainCategoryResDto> allMainCategoryResDtoslist = mainCategoryService.getAllMainCategory();
        List<GetAllMainCategoryResVo> getAllMainCategoryResVoList = new ArrayList<>();

        for (GetAllMainCategoryResDto mainCategoryResDto : allMainCategoryResDtoslist) {
            GetAllMainCategoryResVo getAllMainCategoryResVo = mainCategoryResDto.toVo();
            getAllMainCategoryResVoList.add(getAllMainCategoryResVo);
        }
        return new BaseResponseEntity<>(("메인 카테고리 전체 조회에 성공했습니다"), getAllMainCategoryResVoList);
    }

    /**
     * 3. 메인 카테고리 단건 조회
     *
     * @param mainCategoryUuid 메인 카테고리 UUID
     * @return {@link BaseResponseEntity} 메인 카테고리 단건 조회 결과
     */
    @Operation(summary = "메인 카테고리 단건 조회", tags = {"main-category"})
    @GetMapping("/{mainCategoryUuid}")
    public BaseResponseEntity<GetMainCategoryResVo> getOneMainCategory(
            @PathVariable String mainCategoryUuid
    ) {
        GetMainCategoryResDto getMainCategoryResDto = mainCategoryService.getOneMainCategory(mainCategoryUuid);
        GetMainCategoryResVo getMainCategoryResVo = getMainCategoryResDto.toVo();
        return new BaseResponseEntity<>(("메인 카테고리 단건 조회에 성공했습니다. "), getMainCategoryResVo);
    }

    /**
     * 4. 메인 카테고리 수정
     *
     * @param mainCategoryUuid 메인 카테고리 UUID
     * @param updateMainCategoryReqVo 메인 카테고리 수정 데이터
     * @return {@link BaseResponseEntity} 메인 카테고리 수정 결과
     */
    @Operation(summary = "메인 카테고리 수정", tags = {"main-category"})
    @PutMapping("/{mainCategoryUuid}")
    public BaseResponseEntity<Void> updateMainCategory(
            @PathVariable String mainCategoryUuid,
            @RequestBody UpdateMainCategoryReqVo updateMainCategoryReqVo
    ) {
        mainCategoryService.updateMainCategory(mainCategoryUuid, UpdateMainCategoryReqDto.from(updateMainCategoryReqVo));

        return new BaseResponseEntity<>("메인 카테고리 수정에 성공했습니다. ", null);
    }

    /**
     * 5. 메인 카테고리 삭제
     *
     * @param mainCategoryUuid 메인 카테고리 UUID
     * @return {@link BaseResponseEntity} 메인 카테고리 삭제 결과
     */
    @Operation(summary = "메인 카테고리 삭제", tags = {"main-category"})
    @DeleteMapping("/{mainCategoryUuid}")
    public BaseResponseEntity<Void> deleteMainCategory(
            @PathVariable String mainCategoryUuid
    ) {
        mainCategoryService.deleteMainCategory(mainCategoryUuid);
        return new BaseResponseEntity<>("메인 카테고리 삭제에 성공했습니다. ", null);
    }

    /**
     * 6. 메인 카테고리 이름, 이미지 전체 조회
     *
     * @return {@link BaseResponseEntity} 메인 카테고리 이름,이미지 전체 조회 결과
     */
    @Operation(summary = "메인 카테고리 이름, 이미지 전체 조회", tags = {"main-category"})
    @GetMapping("/side-bar")
    public BaseResponseEntity<List<GetNameAndImageResVo>> getNameAndImageResVo() {
        List<GetNameAndImageResDto> nameAndImageResDtoList = mainCategoryService.getNameAndImage();
        List<GetNameAndImageResVo> getNameAndImageResVoList = new ArrayList<>();

        for (GetNameAndImageResDto getNameAndImageResDto : nameAndImageResDtoList) {
            GetNameAndImageResVo getNameAndImageResVo = getNameAndImageResDto.toVo();
            getNameAndImageResVoList.add(getNameAndImageResVo);
        }
        return new BaseResponseEntity<>("메인 카테고리 이름, 이미지 조회에 성공했습니다. ", getNameAndImageResVoList);

    }
}