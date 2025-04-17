package com.team114.starbucks.domain.product.presentation;


import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.product.application.ProductService;
import com.team114.starbucks.domain.product.dto.in.CreateProductRequestDto;
import com.team114.starbucks.domain.product.dto.in.UpdateProductRequestDto;
import com.team114.starbucks.domain.product.dto.out.CreateProductResponseDto;
import com.team114.starbucks.domain.product.dto.out.GetProductByIdResponseDto;
import com.team114.starbucks.domain.product.dto.out.GetProductPreviewResponseDto;
import com.team114.starbucks.domain.product.dto.out.GetProductResponseDto;
import com.team114.starbucks.domain.product.vo.in.CreateProductRequestVo;
import com.team114.starbucks.domain.product.vo.in.DeleteProductRequestVo;
import com.team114.starbucks.domain.product.vo.in.UpdateProductRequestVo;
import com.team114.starbucks.domain.product.vo.out.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public BaseResponseEntity<List<GetProductResponseDto>> getAllProducts() {

        List<GetProductResponseDto> dtolist = productService.findAllProducts();

        List<GetProductResponseVo> voList = new ArrayList<>();

        for (GetProductResponseDto getProductResponseDto : dtolist) {
            voList.add(getProductResponseDto.toVo());
        }

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 조회 성공", 200, dtolist);


    }

    @GetMapping("/{productUuid}")
    public BaseResponseEntity<GetProductByIdResponseVo> getProduct(
            @PathVariable String productUuid
    ) {
        GetProductByIdResponseDto dto = productService.findProductByUuid(productUuid);

        GetProductByIdResponseVo vo = dto.toVo();

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 단건 조회 성공", 200, vo);
    }

    @PostMapping
    public BaseResponseEntity<CreateProductResponseVo> saveProduct(
            @RequestBody CreateProductRequestVo createProductReqVo
            ) {
        CreateProductRequestDto productPostReqDto = CreateProductRequestDto.from(createProductReqVo);

        CreateProductResponseDto product = productService.saveProduct(productPostReqDto);

        CreateProductResponseVo result = product.toVo();

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 등록 성공", 200, result);

    }

    @PutMapping
    public BaseResponseEntity<Void> updateProduct(
            @RequestBody UpdateProductRequestVo updateProductRequestVo
    ) {
        productService.updateProduct(
                UpdateProductRequestDto.from(updateProductRequestVo)
        );

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 정보를 변경하였습니다.", 200, null);

    }

    @DeleteMapping
    public BaseResponseEntity<Void> deleteProduct(
            @RequestBody DeleteProductRequestVo deleteProductRequestVo
    ) {

        productService.deleteProduct(
                deleteProductRequestVo.getProductUuid()
        );
        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 삭제 성공", 200, null);
    }

    @GetMapping("/preview/{productUuid}")
    public BaseResponseEntity<GetProductPreviewResponseVo> getProductPreview(
            @PathVariable String productUuid
    ) {
        GetProductPreviewResponseDto dto = productService.getProductPreview(productUuid);

        GetProductPreviewResponseVo vo = dto.toVo();

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 미리보기 성공", 200, vo);

    }
}
