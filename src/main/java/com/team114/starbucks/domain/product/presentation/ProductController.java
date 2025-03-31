package com.team114.starbucks.domain.product.presentation;


import com.team114.starbucks.common.entity.BaseResponseEntity;
import com.team114.starbucks.domain.product.application.ProductService;
import com.team114.starbucks.domain.product.dto.in.ProductPostReqDto;
import com.team114.starbucks.domain.product.dto.out.ProductGetResDto;
import com.team114.starbucks.domain.product.vo.in.ProductPostReqVo;
import com.team114.starbucks.domain.product.vo.out.ProductGetResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    /**
     * api/v1/products
     * 1. 상품 조회
     * 2. 상품 등록
     * 3. 상품 수정
     * 4. 상품 삭제
     */


    @GetMapping("/products")
    public List<ProductGetResVo> getAllProducts() {

        List<ProductGetResDto> result = productService.getAllProducts();

        List<ProductGetResVo> responseList = new ArrayList<>();

        for (ProductGetResDto dto : result) {
            responseList.add(dto.toVo());
        }

        return responseList;
    }

    @GetMapping("/products/{id}")
    public BaseResponseEntity<ProductGetResVo> getProduct(@PathVariable Long id) {
        ProductGetResDto result = productService.getProduct(id);

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 조회 성공", 200, result.toVo());
    }

    @PostMapping("/products")
    public BaseResponseEntity<ProductPostReqDto> saveProduct(@RequestBody ProductPostReqVo productPostReqVo) {
        ProductPostReqDto productPostReqDto = ProductPostReqDto.from(productPostReqVo);

        ProductPostReqDto result = productService.saveProduct(productPostReqDto);

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 등록 성공", 200, result);




    }



}
