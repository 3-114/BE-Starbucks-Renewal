package com.team114.starbucks.domain.productcategory.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.productcategory.dto.in.CreateProductCategoryReqDto;
import com.team114.starbucks.domain.productcategory.entity.ProductCategory;
import com.team114.starbucks.domain.productcategory.infrastructure.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    /*
     * 1. 서브 카테고리 생성
     * 2. 서브 카테고리 전체 조회
     * 3. 서브 카테고리 단건 조회
     * 4. 서브 카테고리 수정
     * 5. 서브 카테고리 삭제
     *  */

    private final ProductCategoryRepository productCategoryRepository;

    // 1. 상품 카테고리 생성
    @Override
    public void createProductCategory(CreateProductCategoryReqDto createProductCategoryReqDto) {
        try {
            ProductCategory productCategory = createProductCategoryReqDto.toEntity();

            ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_FIND);
        }


    }
}
