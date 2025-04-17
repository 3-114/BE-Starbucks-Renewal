package com.team114.starbucks.domain.maincategory.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.maincategory.application.MainCategoryService;
import com.team114.starbucks.domain.maincategory.dto.in.CreateMainCategoryReqDto;
import com.team114.starbucks.domain.maincategory.dto.in.UpdateMainCategoryReqDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetAllMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetOneMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.vo.in.CreateMainCategoryReqVo;
import com.team114.starbucks.domain.maincategory.vo.in.UpdateMainCategoryReqVo;
import com.team114.starbucks.domain.maincategory.vo.out.CreateMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.vo.out.CreateMainCategoryResVo;
import com.team114.starbucks.domain.maincategory.vo.out.GetAllMainCategoryResVo;
import com.team114.starbucks.domain.maincategory.vo.out.GetOneMainCategoryResVo;
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
     *  */

    // 1. 메인 카테고리 생성
    @PostMapping
    public BaseResponseEntity<Void> createMainCategory(
            @RequestBody CreateMainCategoryReqVo createMainCategoryReqVo
    ) {
        mainCategoryService.saveMainCategory(CreateMainCategoryReqDto.from(createMainCategoryReqVo));

        return new BaseResponseEntity<>("메인 카테고리 생성에 성공했습니다. ", null);
    }


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

    // 4. 메인 카테고리 수정
    @PutMapping("/{mainCategoryUuid}")
    public BaseResponseEntity<Void> updateMainCategory(
            @PathVariable String mainCategoryUuid,
            @RequestBody UpdateMainCategoryReqVo updateMainCategoryReqVo
    ) {
        mainCategoryService.updateMainCategory(mainCategoryUuid, UpdateMainCategoryReqDto.from(updateMainCategoryReqVo));

        return new BaseResponseEntity<>("메인 카테고리 수정에 성공했습니다. ", null);
    }

    // 5. 메인 카테고리 삭제
    @DeleteMapping("/{mainCategoryUuid}")
    public BaseResponseEntity<Void> deleteMainCategory(
            @PathVariable String mainCategoryUuid
    ){
        mainCategoryService.deleteMainCategory(mainCategoryUuid);

        return new BaseResponseEntity<>("메인 카테고리 삭제에 성공했습니다. ", null);
    }
}




















