package com.team114.starbucks.domain.productcategory.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.maincategory.entity.MainCategory;
import com.team114.starbucks.domain.productcategory.dto.in.CreateProductCategoryReqDto;
import com.team114.starbucks.domain.productcategory.dto.out.GetAllProductUuidResDto;
import com.team114.starbucks.domain.productcategory.entity.ProductCategory;
import com.team114.starbucks.domain.productcategory.infrastructure.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
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
    public Page<ProductCategory> findByMainCategoryUuid(String mainCategoryUuid, Pageable pageable) {
        return productCategoryRepository.findByMainCategoryUuid(mainCategoryUuid, pageable);
    }
}
