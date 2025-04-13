package com.team114.starbucks.domain.product.presentation;


import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.product.application.ProductDescription.ProductDescriptionService;
import com.team114.starbucks.domain.product.dto.in.ProductDescription.CreateProductDescriptionRequestDto;
import com.team114.starbucks.domain.product.dto.in.ProductDescription.UpdateProductDescriptionRequestDto;
import com.team114.starbucks.domain.product.dto.out.ProductDescription.GetProductDescriptionByProductUuidResDto;
import com.team114.starbucks.domain.product.entity.ProductDescription;
import com.team114.starbucks.domain.product.vo.in.ProductDescription.CreateProductDescriptionRequestVo;
import com.team114.starbucks.domain.product.vo.in.ProductDescription.UpdateProductDescriptionRequestVo;
import com.team114.starbucks.domain.product.vo.out.ProductDescription.GetProductDescriptionByProductUuidResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products/description")
public class ProductDescriptionController {

    private final ProductDescriptionService productDescriptionService;

    @PostMapping
    public BaseResponseEntity<Void> createProductDescription(
            @RequestBody CreateProductDescriptionRequestVo createProductDescriptionRequestVo) {

        productDescriptionService.createProductDescription(CreateProductDescriptionRequestDto.from(createProductDescriptionRequestVo));

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 상세내역 등록 성공", 200, null);
    }

    @PutMapping
    public BaseResponseEntity<Void> updateProductDescription(
            @RequestBody UpdateProductDescriptionRequestVo updateProductDescriptionRequestVo) {

        productDescriptionService.updateProductDescription(UpdateProductDescriptionRequestDto.from(updateProductDescriptionRequestVo));

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 상세내역 수정 성공", 200, null);
    }

    @GetMapping("/{productUuid}")
    public BaseResponseEntity<GetProductDescriptionByProductUuidResVo> getProductDescription(
            @PathVariable String productUuid) {

        GetProductDescriptionByProductUuidResVo result = productDescriptionService.getProductDescriptionByProductUuid(productUuid).toVo();

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 상세내역 단건 조회 성공", 200, result);
    }

    @GetMapping
    public BaseResponseEntity<Void> getAllProductDescriptions() {



        return new BaseResponseEntity<>(HttpStatus.OK, true, "모든 상품 상세내역 조회 성공", 200, null);
    }
}
