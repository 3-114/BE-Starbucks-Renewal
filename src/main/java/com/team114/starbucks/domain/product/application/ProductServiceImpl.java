package com.team114.starbucks.domain.product.application;


import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.product.application.ProductThumbnailService.ProductThumbnailService;
import com.team114.starbucks.domain.product.dto.in.CreateProductRequestDto;
import com.team114.starbucks.domain.product.dto.in.UpdateProductRequestDto;
import com.team114.starbucks.domain.product.dto.out.*;
import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.entity.ProductThumbnail;
import com.team114.starbucks.domain.product.infrastructure.ProductRepository;
import com.team114.starbucks.domain.product.infrastructure.ProductThumbnailRepository;
import com.team114.starbucks.domain.product.dto.out.GetProductThumbnailByIdResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductThumbnailRepository productThumbnailRepository;
    private final ProductThumbnailService productThumbnailService;

    @Transactional
    @Override
    public CreateProductResponseDto saveProduct(
            CreateProductRequestDto createProductRequestDto
    ) {
        return CreateProductResponseDto.from(productRepository.save(createProductRequestDto.toEntity(UUID.randomUUID().toString())));
    }

    @Transactional
    @Override
    public void updateProduct(
            UpdateProductRequestDto updateProductRequestDto
    ) {
        Product product = productRepository.findByProductUuid(updateProductRequestDto.getProductUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        List<ProductThumbnail> productThumbnailList = productThumbnailRepository.findByProductId(product.getId());

        productThumbnailRepository.deleteAll(productThumbnailList);

        productThumbnailRepository.saveAll(productThumbnailList);
    }

    @Transactional
    @Override
    public Void deleteProduct(String productUuid) {

        Product product = productRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        List<ProductThumbnail> productThumbnailList = productThumbnailRepository.findByProductId(
                product.getId());

//        productThumbnailRepository.deleteAllByIdInBatch(productThumbnailList.stream()
//                .map(ProductThumbnail::getId)
//                .toList());

        productThumbnailRepository.deleteAll(productThumbnailList);

        productRepository.deleteByProductUuid(productUuid);

        return null;
    }

    @Override
    public GetProductPreviewResponseDto getProductPreview(String productUuid) { // 이거 썸네일로 가는게 맞는 것 같음 or 참조방향 자체가 잘못됨.

        Product product = productRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        List<ProductThumbnail> productThumbnailList =
                productThumbnailService.getProductThumbnailById(product);

        ProductThumbnail productThumbnail = productThumbnailList.stream()
                .filter(thumbnail -> Boolean.TRUE.equals(thumbnail.getIsThumbnail()))
                .findFirst()
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        return GetProductPreviewResponseDto.from(product, productThumbnail);
    }

    @Override
    public Boolean checkProductExist(String productUuid) {
        return productRepository.existsByProductUuid(productUuid);
    }


    @Override
    public GetProductByIdResponseDto findProductByUuid(String productUuid) {

        Product product = productRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        List<GetProductThumbnailByIdResponseDto> getProductThumbnailByIdResponseDtoList = productThumbnailService
                .getProductThumbnailById(product)
                .stream()
                .map(GetProductThumbnailByIdResponseDto::from)
                .toList();

        return GetProductByIdResponseDto.from(product, getProductThumbnailByIdResponseDtoList);
    }

    @Override
    public List<GetProductResponseDto> findAllProducts() {
        // 상품 전체 조회 (썸네일X)
        return productRepository.findAll()
                .stream()
                .map(GetProductResponseDto::from)
                .toList();

    }




}
