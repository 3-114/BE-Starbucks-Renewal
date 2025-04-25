package com.team114.starbucks.domain.product.application;


import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.product.application.ProductThumbnailService.ProductThumbnailService;
import com.team114.starbucks.domain.product.dto.in.CreateProductReqDto;
import com.team114.starbucks.domain.product.dto.in.UpdateProductReqDto;
import com.team114.starbucks.domain.product.dto.out.*;
import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.entity.ProductThumbnail;
import com.team114.starbucks.domain.product.infrastructure.ProductRepository;
import com.team114.starbucks.domain.product.infrastructure.ProductThumbnailRepository;
import com.team114.starbucks.domain.product.dto.out.GetProductThumbnailByIdResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public CreateProductResDto saveProduct(
            CreateProductReqDto createProductReqDto
    ) {
        String uuid = UUID.randomUUID().toString();
        if (productRepository.existsByProductUuid(uuid)) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_PRODUCT);
        }

        Product newProduct = createProductReqDto.toEntity(uuid);
        productRepository.save(newProduct);
        productThumbnailService.saveAllProductThumbnail(
                newProduct,
                createProductReqDto.getProductThumbnailList()
        );
        CreateProductResDto resDto = CreateProductResDto.from(newProduct);

        return resDto;
    }

    @Transactional
    @Override
    public void updateProduct(
            UpdateProductReqDto updateProductReqDto
    ) {
        Product product = productRepository.findByProductUuid(updateProductReqDto.getProductUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));
        Product newProduct = updateProductReqDto.updateProduct(product);
        productRepository.save(newProduct);

        List<ProductThumbnail> productThumbnailList = productThumbnailRepository.findByProductId(product.getId());
        productThumbnailRepository.deleteAll(productThumbnailList);

        productThumbnailRepository.saveAll(updateProductReqDto.getProductThumbnailList()
                .stream()
                .map(thumbnail -> thumbnail.toEntity(product))
                .toList());
    }

    @Transactional
    @Override
    public void deleteProduct(String productUuid) {
        Product product = productRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        List<ProductThumbnail> productThumbnailList = productThumbnailRepository.findByProductId(
                product.getId());
        productThumbnailRepository.deleteAll(productThumbnailList);

        productRepository.deleteByProductUuid(productUuid);
    }

    @Override
    public GetProductPreviewResDto getProductPreview(String productUuid) {
        Product product = productRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        List<ProductThumbnail> productThumbnailList =
                productThumbnailService.getProductThumbnailById(product);

        ProductThumbnail productThumbnail = productThumbnailList.stream()
                .filter(thumbnail -> Boolean.TRUE.equals(thumbnail.getIsThumbnail()))
                .findFirst()
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        return GetProductPreviewResDto.from(product, productThumbnail);
    }

    @Override
    public Boolean checkProductExist(String productUuid) {
        return productRepository.existsByProductUuid(productUuid);
    }

    @Override
    public GetProductByIdResDto findProductByUuid(String productUuid) {

        Product product = productRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        List<GetProductThumbnailByIdResDto> getProductThumbnailByIdResDtoList = productThumbnailService
                .getProductThumbnailById(product)
                .stream()
                .map(GetProductThumbnailByIdResDto::from)
                .toList();

        return GetProductByIdResDto.from(product, getProductThumbnailByIdResDtoList);
    }

    @Override
    public List<GetProductResDto> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(GetProductResDto::from)
                .toList();
    }

}