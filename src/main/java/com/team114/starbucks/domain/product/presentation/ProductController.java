package com.team114.starbucks.domain.product.presentation;


import com.team114.starbucks.domain.product.application.ProductService;
import com.team114.starbucks.domain.product.dto.out.ProductResponseDto;
import com.team114.starbucks.domain.product.vo.out.ProductResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<ProductResponseVo> getAllProducts() {
        List<ProductResponseDto> result = productService.getAllProducts();

        List<ProductResponseVo> responseList = new ArrayList<>();

        for (ProductResponseDto dto : result) {
            responseList.add(dto.toVo());
        }


        return responseList;
    }


}
