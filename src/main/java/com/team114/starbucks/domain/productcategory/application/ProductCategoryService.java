package com.team114.starbucks.domain.productcategory.application;

import com.team114.starbucks.domain.maincategory.entity.MainCategory;
import com.team114.starbucks.domain.productcategory.dto.in.CreateProductCategoryReqDto;
import com.team114.starbucks.domain.productcategory.dto.out.GetAllProductUuidResDto;
import com.team114.starbucks.domain.productcategory.entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//@Service
public interface ProductCategoryService {

    void createProductCategory(CreateProductCategoryReqDto createProductCategoryReqDto);

    List<GetAllProductUuidResDto> getProductUuidsByEventUuid(String eventUuid);

    Page<ProductCategory> findByMainCategoryUuid(String mainCategoryUuid, Pageable pageable);
}
