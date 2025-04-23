package com.team114.starbucks.domain.product.presentation;


import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.product.application.ProductDescription.ProductDescriptionService;
import com.team114.starbucks.domain.product.dto.in.ProductDescription.CreateProductDescriptionRequestDto;
import com.team114.starbucks.domain.product.dto.in.ProductDescription.UpdateProductDescriptionRequestDto;
import com.team114.starbucks.domain.product.vo.in.ProductDescription.CreateProductDescriptionRequestVo;
import com.team114.starbucks.domain.product.vo.in.ProductDescription.UpdateProductDescriptionRequestVo;
import com.team114.starbucks.domain.product.vo.out.ProductDescription.GetProductDescriptionAllResDto;
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

    @Operation(summary = "상품 상세내용 생성", tags = {"Product_Description"})
    @PostMapping
    public BaseResponseEntity<Void> createProductDescription(
            @RequestBody CreateProductDescriptionRequestVo createProductDescriptionRequestVo) {

        productDescriptionService.createProductDescription(CreateProductDescriptionRequestDto.from(createProductDescriptionRequestVo));

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 상세내역 등록 성공", 200, null);
    }

    @Operation(summary = "상품 상세내용 수정", tags = {"Product_Description"})
    @PutMapping
    public BaseResponseEntity<Void> updateProductDescription(
            @RequestBody UpdateProductDescriptionRequestVo updateProductDescriptionRequestVo) {

        productDescriptionService.updateProductDescription(UpdateProductDescriptionRequestDto.from(updateProductDescriptionRequestVo));

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 상세내역 수정 성공", 200, null);
    }

    @Operation(summary = "상품 상세내용 단건 조회", tags = {"Product_Description"})
    @GetMapping("/{productUuid}")
    public BaseResponseEntity<GetProductDescriptionByProductUuidResVo> getProductDescription(
            @PathVariable String productUuid) {

        GetProductDescriptionByProductUuidResVo result = productDescriptionService.getProductDescriptionByProductUuid(productUuid).toVo();

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 상세내역 단건 조회 성공", 200, result);
    }

    @Operation(summary = "상품 상세내용 전체 조회", tags = {"Product_Description"})
    @GetMapping
    public BaseResponseEntity<List<GetProductDescriptionAllResDto>> getAllProductDescriptions() {

        List<GetProductDescriptionAllResDto> result = productDescriptionService.getProductDescriptionAll()
                .stream()
                .map(com.team114.starbucks.domain.product.dto.out.ProductDescription.GetProductDescriptionAllResDto::toVo)
                .toList();


        return new BaseResponseEntity<>(HttpStatus.OK, true, "모든 상품 상세내역 조회 성공", 200, result);
    }
}
