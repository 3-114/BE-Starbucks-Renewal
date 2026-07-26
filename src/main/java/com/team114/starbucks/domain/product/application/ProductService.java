package com.team114.starbucks.domain.product.application;

import com.team114.starbucks.domain.product.dto.in.CreateProductReqDto;
import com.team114.starbucks.domain.product.dto.in.UpdateProductReqDto;
import com.team114.starbucks.domain.product.dto.out.*;

import java.util.List;

public interface ProductService {

    GetProductByIdResDto findProductByUuid(String productUuid);

    List<GetProductResDto> findAllProducts();

    CreateProductResDto saveProduct(CreateProductReqDto createProductReqDto);

    void updateProduct(UpdateProductReqDto updateProductReqDto);

    void deleteProduct(String productUuid);

    GetProductPreviewResDto getProductPreview(String productUuid);

    Boolean checkProductExist(String productUuid);

}