package com.team114.starbucks.domain.maincategory.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.maincategory.application.MainCategoryService;
import com.team114.starbucks.domain.maincategory.dto.out.GetAllMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetOneMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.vo.out.GetAllMainCategoryResVo;
import com.team114.starbucks.domain.maincategory.vo.out.GetOneMainCategoryResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     *  */

    // 2. 메인 카테고리 전체 조회
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

    // 3. 메인 카테고리 단건 조회
    @GetMapping("/{mainCategoryUuid}")
    public BaseResponseEntity<GetOneMainCategoryResVo> getOneMainCategory(
            @PathVariable String mainCategoryUuid
    ) {
        GetOneMainCategoryResDto getOneMainCategoryResDto = mainCategoryService.getOneMainCategory(mainCategoryUuid);
        GetOneMainCategoryResVo getOneMainCategoryResVo = getOneMainCategoryResDto.toVo();
        return new BaseResponseEntity<>(("메인 카테고리 단건 조회에 성공했습니다. "), getOneMainCategoryResVo);
    }

}




















