package com.team114.starbucks.domain.productcategory.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.productcategory.application.ProductCategoryService;
import com.team114.starbucks.domain.productcategory.dto.in.CreateProductCategoryReqDto;
import com.team114.starbucks.domain.productcategory.vo.in.CreateProductCategoryReqVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product-category")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    /*
     * 1. 상품 카테고리 생성
     * 2. 상품 카테고리 전체 조회
     * 3. 상품 카테고리 단건 조회
     * 4. 상품 카테고리 수정
     * 5. 상품 카테고리 삭제
     *  */

    // 1. 상품 카테고리 생성
    @PostMapping
    public BaseResponseEntity<Void> createProductCategory(
            @RequestBody CreateProductCategoryReqVo createProductCategoryReqVo
    ) {
        productCategoryService.createProductCategory(CreateProductCategoryReqDto.from(createProductCategoryReqVo));

        return new BaseResponseEntity<>("상품 카테고리 생성에 성공했습니다. ", null);

    }

}
