package com.team114.starbucks.domain.productcategory.application;

import com.team114.starbucks.domain.productcategory.dto.in.CreateProductCategoryReqDto;
import com.team114.starbucks.domain.productcategory.dto.in.EventImageParamReqDto;
import com.team114.starbucks.domain.productcategory.dto.in.PageParamDto;
import com.team114.starbucks.domain.productcategory.dto.out.GetAllProductUuidResDto;
import com.team114.starbucks.domain.productcategory.vo.out.GetAllProductUuidResVo;
import org.springframework.data.domain.Page;

import java.util.List;

//@Service
public interface ProductCategoryService {

    void createProductCategory(CreateProductCategoryReqDto createProductCategoryReqDto);

    List<GetAllProductUuidResDto> getProductUuidsByEventUuid(String eventUuid);

    Page<GetAllProductUuidResDto> getProductUuids(PageParamDto pageParamDto);

    Page<GetAllProductUuidResDto> getEventProductUuids(EventImageParamReqDto eventImageParamReqDto);
}
