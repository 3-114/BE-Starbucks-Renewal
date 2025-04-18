package com.team114.starbucks.domain.product.application;

import com.team114.starbucks.domain.product.dto.in.CreateProductRequestDto;
import com.team114.starbucks.domain.product.dto.in.PageParamReqDto;
import com.team114.starbucks.domain.product.dto.in.PaginationParamDto;
import com.team114.starbucks.domain.product.dto.in.UpdateProductRequestDto;
import com.team114.starbucks.domain.product.dto.out.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    GetProductByIdResponseDto findProductByUuid(String productUuid);

    List<GetProductResponseDto> findAllProducts();

    CreateProductResponseDto saveProduct(CreateProductRequestDto createProductRequestDto);

    void updateProduct(UpdateProductRequestDto updateProductRequestDto);

    Void deleteProduct(String productUuid);

    GetProductPreviewResponseDto getProductPreview(String productUuid);

    Boolean checkProductExist(String productUuid);


    Page<ProductUuidResDto> getProductUuids(PageParamReqDto pageParamReqDto, PaginationParamDto paginationParamDto);
}
