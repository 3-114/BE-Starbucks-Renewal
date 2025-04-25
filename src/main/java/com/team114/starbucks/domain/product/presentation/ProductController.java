package com.team114.starbucks.domain.product.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.product.application.ProductService;
import com.team114.starbucks.domain.product.dto.in.CreateProductReqDto;
import com.team114.starbucks.domain.product.dto.in.UpdateProductReqDto;
import com.team114.starbucks.domain.product.dto.out.CreateProductResDto;
import com.team114.starbucks.domain.product.dto.out.GetProductByIdResDto;
import com.team114.starbucks.domain.product.dto.out.GetProductPreviewResDto;
import com.team114.starbucks.domain.product.dto.out.GetProductResDto;
import com.team114.starbucks.domain.product.vo.in.CreateProductReqVo;
import com.team114.starbucks.domain.product.vo.in.DeleteProductReqVo;
import com.team114.starbucks.domain.product.vo.in.UpdateProductReqVo;
import com.team114.starbucks.domain.product.vo.out.CreateProductResVo;
import com.team114.starbucks.domain.product.vo.out.GetProductByIdResVo;
import com.team114.starbucks.domain.product.vo.out.GetProductPreviewResVo;
import com.team114.starbucks.domain.product.vo.out.GetProductResVo;
import io.swagger.v3.oas.annotations.Operation;
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

    /**
     * 1. 상품 생성
     * 2. 상품 전체 조회
     * 3. 상품 단건 조회
     * 4. 상품 수정
     * 5. 상품 삭제
     * 6. 상품 프리뷰 조회
     */

    /**
     * 1. 상품 생성
     *
     * @param createProductReqVo 상품 정보
     * @return {@link BaseResponseEntity} 상품 생성 결과
     */
    @Operation(summary = "상품 생성", tags = {"Product"})
    @PostMapping
    public BaseResponseEntity<CreateProductResVo> saveProduct(
            @RequestBody CreateProductReqVo createProductReqVo
    ) {
        CreateProductReqDto productPostReqDto = CreateProductReqDto.from(createProductReqVo);
        CreateProductResDto product = productService.saveProduct(productPostReqDto);
        CreateProductResVo result = product.toVo();

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 등록 성공", 200, result);
    }

    /**
     * 2. 상품 전체 조회
     *
     * @return {@link BaseResponseEntity} 상품 전체 조회 결과
     */
    @Operation(summary = "상품 전체 조회", tags = {"Product"})
    @GetMapping
    public BaseResponseEntity<List<GetProductResDto>> getAllProducts() {
        List<GetProductResDto> dtolist = productService.findAllProducts();
        List<GetProductResVo> voList = new ArrayList<>();

        for (GetProductResDto getProductResDto : dtolist) {
            voList.add(getProductResDto.toVo());
        }

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 조회 성공", 200, dtolist);
    }

    /**
     * 3. 상품 단건 조회
     *
     * @param productUuid 상품 UUID
     * @return {@link BaseResponseEntity} 상품 단건 조회 결과
     */
    @Operation(summary = "상품 단건 조회", tags = {"Product"})
    @GetMapping("/{productUuid}")
    public BaseResponseEntity<GetProductByIdResVo> getProduct(
            @PathVariable String productUuid
    ) {
        GetProductByIdResDto dto = productService.findProductByUuid(productUuid);
        GetProductByIdResVo vo = dto.toVo();

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 단건 조회 성공", 200, vo);
    }

    /**
     * 4. 상품 수정
     *
     * @param updateProductReqVo 상품 수정 데이터
     * @return {@link BaseResponseEntity} 상품 수정 결과
     */
    @Operation(summary = "상품 수정", tags = {"Product"})
    @PutMapping
    public BaseResponseEntity<Void> updateProduct(
            @RequestBody UpdateProductReqVo updateProductReqVo
    ) {
        productService.updateProduct(UpdateProductReqDto.from(updateProductReqVo));

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 정보를 변경하였습니다.", 200, null);
    }

    /**
     * 5. 상품 삭제
     *
     * @param deleteProductReqVo 상품 삭제 데이터
     * @return {@link BaseResponseEntity} 상품 삭제 결과
     */
    @Operation(summary = "상품 삭제", tags = {"Product"})
    @DeleteMapping
    public BaseResponseEntity<Void> deleteProduct(
            @RequestBody DeleteProductReqVo deleteProductReqVo
    ) {
        productService.deleteProduct(
                deleteProductReqVo.getProductUuid()
        );

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 삭제 성공", 200, null);
    }

    /**
     * 6. 상품 프리뷰 조회
     *
     * @param productUuid 상품 UUID
     * @return {@link BaseResponseEntity} 상품 삭제 결과
     */
    @Operation(summary = "상품 프리뷰 조회", tags = {"Product"})
    @GetMapping("/preview/{productUuid}")
    public BaseResponseEntity<GetProductPreviewResVo> getProductPreview(
            @PathVariable String productUuid
    ) {
        GetProductPreviewResDto dto = productService.getProductPreview(productUuid);
        GetProductPreviewResVo vo = dto.toVo();

        return new BaseResponseEntity<>(HttpStatus.OK, true, "상품 미리보기 성공", 200, vo);
    }

}