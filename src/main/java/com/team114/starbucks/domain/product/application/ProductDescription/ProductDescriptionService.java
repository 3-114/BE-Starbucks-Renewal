package com.team114.starbucks.domain.product.application.ProductDescription;

import com.team114.starbucks.domain.product.dto.in.ProductDescription.CreateProductDescriptionReqDto;
import com.team114.starbucks.domain.product.dto.in.ProductDescription.UpdateProductDescriptionReqDto;
import com.team114.starbucks.domain.product.dto.out.ProductDescription.GetAllProductDescriptionResDto;
import com.team114.starbucks.domain.product.dto.out.ProductDescription.GetProductDescriptionByProductUuidResDto;

import java.util.List;

public interface ProductDescriptionService {

    void createProductDescription(CreateProductDescriptionReqDto createProductDescriptionReqDto);

    void updateProductDescription(UpdateProductDescriptionReqDto updateProductDescriptionReqDto);

    GetProductDescriptionByProductUuidResDto getProductDescriptionByProductUuid(String ProductUuid);

    List<GetAllProductDescriptionResDto> getProductDescriptionAll();

}
