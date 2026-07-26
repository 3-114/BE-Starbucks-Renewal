package com.team114.starbucks.domain.productcategory.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.productcategory.dto.in.CreateProductCategoryReqDto;
import com.team114.starbucks.domain.productcategory.dto.in.GetAllEventImageParamReqDto;
import com.team114.starbucks.domain.productcategory.dto.in.PageParamDto;
import com.team114.starbucks.domain.productcategory.dto.out.GetAllProductUuidResDto;
import com.team114.starbucks.domain.productcategory.entity.ProductCategory;
import com.team114.starbucks.domain.productcategory.infrastructure.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Transactional
    @Override
    public void createProductCategory(CreateProductCategoryReqDto createProductCategoryReqDto) {
        try {
            ProductCategory productCategory = createProductCategoryReqDto.toEntity();

            ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_FIND);
        }
    }

    @Override
    public List<GetAllProductUuidResDto> getProductUuidsByEventUuid(String eventUuid) {

        return productCategoryRepository.findAllProductUuidByEventUuid(eventUuid).stream().map(GetAllProductUuidResDto::from).toList();
    }

    @Override
    public Page<GetAllProductUuidResDto> getProductUuids(PageParamDto pageParamDto) {
        return pageParamDto.getMainCategoryUuid() == null
                ? productCategoryRepository.findAll(pageParamDto.toEntity()).map(GetAllProductUuidResDto::from)
                : productCategoryRepository.findByMainCategoryUuid(
                        pageParamDto.getMainCategoryUuid(), pageParamDto.toEntity())
                .map(GetAllProductUuidResDto::from);
    }

    @Override
    public Page<GetAllProductUuidResDto> getEventProductUuids(GetAllEventImageParamReqDto getAllEventImageParamReqDto) {
        return productCategoryRepository.findAllProductUuidByEventUuid(
                        getAllEventImageParamReqDto.getEventUuid(), getAllEventImageParamReqDto.toPageable())
                .map(GetAllProductUuidResDto::from);
    }

}