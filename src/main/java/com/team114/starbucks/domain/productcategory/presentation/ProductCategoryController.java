package com.team114.starbucks.domain.productcategory.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.productcategory.application.ProductCategoryService;
import com.team114.starbucks.domain.productcategory.dto.in.CreateProductCategoryReqDto;
import com.team114.starbucks.domain.productcategory.dto.in.GetAllEventImageParamReqDto;
import com.team114.starbucks.domain.productcategory.dto.in.PageParamDto;
import com.team114.starbucks.domain.productcategory.dto.out.GetAllProductUuidResDto;
import com.team114.starbucks.domain.productcategory.vo.in.CreateProductCategoryReqVo;
import com.team114.starbucks.domain.productcategory.vo.out.GetAllProductUuidResVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product-category")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    /*
     * 1. 상품 카테고리 생성
     * 2. 상품 eventUuid로 상품 리스트 조회
     * 3. product uuid 리스트 조회
     * 4. 기획전 상세내역 상품 리스트 조회
     *  */

    /**
     * 1. 상품 카테고리 생성
     *
     * @param createProductCategoryReqVo 상품 카테고리 데이터
     * @return {@link BaseResponseEntity} 상품 카테고리 생성 결과
     */
    @Operation(summary = "카테고리 항목 생성", tags = {"Product_Category"})
    @PostMapping
    public BaseResponseEntity<Void> createProductCategory(
            @RequestBody CreateProductCategoryReqVo createProductCategoryReqVo
    ) {
        productCategoryService.createProductCategory(CreateProductCategoryReqDto.from(createProductCategoryReqVo));

        return new BaseResponseEntity<>("상품 카테고리 생성에 성공했습니다. ", null);
    }

    /**
     * 2. 상품 eventUuid로 상품 리스트 조회
     *
     * @param eventUuid 상품 UUID
     * @return {@link BaseResponseEntity} 상품 리스트 조회 결과
     */
    @Operation(summary = "eventUuid로 상품 리스트 조회", tags = {"Product_Category"}, hidden = true)
    @GetMapping("/{eventUuid}")
    public BaseResponseEntity<List<GetAllProductUuidResVo>> getProductUuidsByEventUuid(
            @PathVariable String eventUuid
    ) {
        return new BaseResponseEntity<>("상품 카테고리의 product UUID 조회에 성공했습니다. ",
                productCategoryService.getProductUuidsByEventUuid(eventUuid).stream().map(GetAllProductUuidResDto::toVo).toList());
    }

    /**
     * 3. product uuid 리스트 조회"
     *
     * @param mainCategoryUuid 메인 카테고리 UUID
     * @param page             페이지
     * @param size             사이즈
     * @return {@link BaseResponseEntity} 상품 리스트 조회 결과
     */
    @Operation(summary = "product uuid 리스트 조회", tags = {"Product"})
    @GetMapping("/uuid-list")
    public BaseResponseEntity<Page<GetAllProductUuidResVo>> getProductUuids(
            @RequestParam(required = false) String mainCategoryUuid,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        return new BaseResponseEntity<>(
                "product uuid 리스트 조회에 성공하였습니다.",
                productCategoryService.getProductUuids(PageParamDto.of(mainCategoryUuid, page, size)).map(GetAllProductUuidResDto::toVo)
        );
    }

    /**
     * 4. 기획전 상세내역 상품 리스트 조회
     *
     * @param eventUuid 상품 UUID
     * @param page      페이지
     * @param size      사이즈
     * @return {@link BaseResponseEntity} 상품 리스트 조회 결과
     */
    @Operation(summary = "기획전 상세내역 상품 리스트 조회", tags = {"event"})
    @GetMapping("/uuid-list/event")
    public BaseResponseEntity<Page<GetAllProductUuidResVo>> getEventProductUuids(
            @RequestParam String eventUuid,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        return new BaseResponseEntity<>(
                "product uuid 리스트 조회에 성공했습니다.",
                productCategoryService.getEventProductUuids(GetAllEventImageParamReqDto.of(eventUuid, page, size))
                        .map(GetAllProductUuidResDto::toVo)
        );
    }

}