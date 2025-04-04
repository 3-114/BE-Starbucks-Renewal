package com.team114.starbucks.domain.product.presentation;


import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.product.application.ProductService;
import com.team114.starbucks.domain.product.dto.in.CreateProductRequestDto;
import com.team114.starbucks.domain.product.dto.out.CreateProductResponseDto;
import com.team114.starbucks.domain.product.dto.out.GetByIdResponseDto;
import com.team114.starbucks.domain.product.dto.out.GetProductResponseDto;
import com.team114.starbucks.domain.product.vo.in.CreateProductRequestVo;
import com.team114.starbucks.domain.product.vo.out.CreateProductResponseVo;
import com.team114.starbucks.domain.product.vo.out.GetByIdResponseVo;
import com.team114.starbucks.domain.product.vo.out.GetProductResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public BaseResponseEntity<List<GetProductResponseVo>> getAllProducts() {

        List<GetProductResponseDto> dtolist = productService.findAllProducts();

        List<GetProductResponseVo> voList = new ArrayList<>();

        for (GetProductResponseDto getProductResponseDto : dtolist) {
            voList.add(getProductResponseDto.toVo());
        }

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 조회 성공", 200, voList);


    }

    @GetMapping("/{productUuid}")
    public BaseResponseEntity<GetByIdResponseVo> getProduct(
            @PathVariable String productUuid
    ) {
        GetByIdResponseDto dto = productService.findProductByUuid(productUuid);

        GetByIdResponseVo vo = dto.toVo();

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 단건 조회 성공", 200, vo);



    }

    @PostMapping
    public BaseResponseEntity<CreateProductResponseVo> saveProduct(@RequestBody CreateProductRequestVo createProductReqVo) {
        CreateProductRequestDto productPostReqDto = CreateProductRequestDto.from(createProductReqVo);

        CreateProductResponseDto product = productService.saveProduct(productPostReqDto);

        CreateProductResponseVo result = product.toVo();

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 등록 성공", 200, result);

    }





}
