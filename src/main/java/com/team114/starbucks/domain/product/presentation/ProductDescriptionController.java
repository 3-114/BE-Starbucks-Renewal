package com.team114.starbucks.domain.product.presentation;


import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.product.application.ProductDescription.ProductDescriptionService;
import com.team114.starbucks.domain.product.dto.in.ProductDescription.CreateProductDescriptionReqDto;
import com.team114.starbucks.domain.product.dto.in.ProductDescription.UpdateProductDescriptionReqDto;
import com.team114.starbucks.domain.product.vo.in.ProductDescription.CreateProductDescriptionReqVo;
import com.team114.starbucks.domain.product.vo.in.ProductDescription.UpdateProductDescriptionReqVo;
import com.team114.starbucks.domain.product.vo.out.ProductDescription.GetAllProductDescriptionResDto;
import com.team114.starbucks.domain.product.vo.out.ProductDescription.GetProductDescriptionByProductUuidResVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products/description")
public class ProductDescriptionController {

    private final ProductDescriptionService productDescriptionService;

    /**
     * 1. 상품 상세내용 생성
     * 2. 상품 상세내용 전체 조회
     * 3. 상품 상세내용 단건 조회
     * 4. 상품 상세내용 수정
     */

    /**
     * 1. 상품 상세내용 생성
     *
     * @param createProductDescriptionReqVo 상품 상세내용 데이터
     * @return {@link BaseResponseEntity} 상품 상세내용 생성 결과
     */
    @Operation(summary = "상품 상세내용 생성", tags = {"Product_Description"})
    @PostMapping
    public BaseResponseEntity<Void> createProductDescription(
            @RequestBody CreateProductDescriptionReqVo createProductDescriptionReqVo) {
        productDescriptionService.createProductDescription(CreateProductDescriptionReqDto.from(createProductDescriptionReqVo));

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 상세내역 등록 성공", 200, null);
    }

    /**
     * 2. 상품 상세내용 전체 조회
     *
     * @return {@link BaseResponseEntity} 상품 상세내용 전체 조회 결과
     */
    @Operation(summary = "상품 상세내용 전체 조회", tags = {"Product_Description"})
    @GetMapping
    public BaseResponseEntity<List<GetAllProductDescriptionResDto>> getAllProductDescriptions() {
        List<GetAllProductDescriptionResDto> result = productDescriptionService.getProductDescriptionAll()
                .stream()
                .map(com.team114.starbucks.domain.product.dto.out.ProductDescription.GetAllProductDescriptionResDto::toVo)
                .toList();

        return new BaseResponseEntity<>(HttpStatus.OK, true, "모든 상품 상세내역 조회 성공", 200, result);
    }

    /**
     * 3. 상품 상세내용 단건 조회
     *
     * @param productUuid 상품 UUID
     * @return {@link BaseResponseEntity} 상품 상세내용 단건 조회 결과
     */
    @Operation(summary = "상품 상세내용 단건 조회", tags = {"Product_Description"})
    @GetMapping("/{productUuid}")
    public BaseResponseEntity<GetProductDescriptionByProductUuidResVo> getProductDescription(
            @PathVariable String productUuid) {
        GetProductDescriptionByProductUuidResVo result = productDescriptionService.getProductDescriptionByProductUuid(productUuid).toVo();

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 상세내역 단건 조회 성공", 200, result);
    }

    /**
     * 4. 상품 상세내용 수정
     *
     * @param updateProductDescriptionReqVo 상품 상세내용 수정 데이터
     * @return {@link BaseResponseEntity} 상품 상세내용 수정 결과
     */
    @Operation(summary = "상품 상세내용 수정", tags = {"Product_Description"})
    @PutMapping
    public BaseResponseEntity<Void> updateProductDescription(
            @RequestBody UpdateProductDescriptionReqVo updateProductDescriptionReqVo) {
        productDescriptionService.updateProductDescription(UpdateProductDescriptionReqDto.from(updateProductDescriptionReqVo));

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 상세내역 수정 성공", 200, null);
    }

}