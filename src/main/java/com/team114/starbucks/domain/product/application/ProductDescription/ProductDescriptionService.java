package com.team114.starbucks.domain.product.application.ProductDescription;

import com.team114.starbucks.domain.product.dto.in.ProductDescription.CreateProductDescriptionRequestDto;
import com.team114.starbucks.domain.product.dto.in.ProductDescription.UpdateProductDescriptionRequestDto;
import com.team114.starbucks.domain.product.dto.out.ProductDescription.GetProductDescriptionAllResDto;
import com.team114.starbucks.domain.product.dto.out.ProductDescription.GetProductDescriptionByProductUuidResDto;
import com.team114.starbucks.domain.product.entity.ProductDescription;
import org.hibernate.query.Page;

import java.util.List;
import java.util.Optional;

public interface ProductDescriptionService {
    void createProductDescription(CreateProductDescriptionRequestDto createProductDescriptionRequestDto);
    void updateProductDescription(UpdateProductDescriptionRequestDto updateProductDescriptionRequestDto);

    // productUuid is Unique
    GetProductDescriptionByProductUuidResDto getProductDescriptionByProductUuid(String ProductUuid);

    List<GetProductDescriptionAllResDto> getProductDescriptionAll();

}
