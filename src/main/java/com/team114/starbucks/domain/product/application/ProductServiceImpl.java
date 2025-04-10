package com.team114.starbucks.domain.product.application;


import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.product.dto.in.CreateProductRequestDto;
import com.team114.starbucks.domain.product.dto.in.CreateProductThumbnailRequestDto;
import com.team114.starbucks.domain.product.dto.in.UpdateProductRequestDto;
import com.team114.starbucks.domain.product.dto.in.UpdateProductThumbnailRequestDto;
import com.team114.starbucks.domain.product.dto.out.*;
import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.entity.ProductDescription;
import com.team114.starbucks.domain.product.entity.ProductThumbnail;
import com.team114.starbucks.domain.product.infrastructure.ProductDescriptionRepository;
import com.team114.starbucks.domain.product.infrastructure.ProductRepository;
import com.team114.starbucks.domain.product.infrastructure.ProductThumbnailRepository;
import com.team114.starbucks.domain.product.dto.out.GetProductThumbnailByIdResponseDto;

import com.team114.starbucks.domain.product.vo.in.UpdateProductThumbnailRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductThumbnailRepository productThumbnailRepository;
    private final ProductDescriptionRepository productDescriptionRepository;

    @Transactional
    @Override
    public CreateProductResponseDto saveProduct(
            CreateProductRequestDto dto
    ) {

        // 상품 저장
        Product savedProduct = productRepository.save(dto.toEntity(UUID.randomUUID().toString()));

        // 상품 Thumbnail 저장
        for (CreateProductThumbnailRequestDto createProductThumbnailRequestDto : dto.getProductThumbnailList()) {
            productThumbnailRepository.save(createProductThumbnailRequestDto.toEntity(savedProduct));
        }

        // 상품 Description 저장
        ProductDescription productDescription = ProductDescription.builder()
                .productDescription(dto.getProductDescription())
                .productUuid(savedProduct.getProductUuid())
                .build();

        productDescriptionRepository.save(productDescription);



        return CreateProductResponseDto.from(savedProduct, productDescription);


    }

    @Transactional
    @Override
    public Void updateProduct(
            UpdateProductRequestDto updateProductRequestDto
    ) {
        // 상품 uuid로 상품 조회
        Product product = productRepository.findByProductUuid(updateProductRequestDto.getProductUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        // 상품 UUID로 상세내역 조회
        ProductDescription productDescription = productDescriptionRepository.findByProductUuid(
                updateProductRequestDto.getProductUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));
        // 해당 상품에 대한 썸네일 리스트 조회(릴레이션 O, UUID X, 공부용)
        List<ProductThumbnail> productThumbnailList = productThumbnailRepository.findByProductId(
                product.getId());

        // 기존 상세내역  삭제
        productDescriptionRepository.deleteByProductUuid(updateProductRequestDto.getProductUuid());

        // 기존 썸네일 리스트 삭제
        for (ProductThumbnail productThumbnail : productThumbnailList) {
            productThumbnailRepository.delete(productThumbnail);
        }


        // 기존 상세내역 업데이트(저장) 추후 리팩토링 예정
        productDescriptionRepository.save(
                ProductDescription.builder()
                        .productDescription(updateProductRequestDto.getProductDescription())
                        .productUuid(product.getProductUuid())
                        .build()
        );

        // 기존 썸네일 리스트 업데이트(저장)
        for (UpdateProductThumbnailRequestDto updateProductThumbnailRequestDto :
                updateProductRequestDto.getProductThumbnailList()) {
            productThumbnailRepository.save(updateProductThumbnailRequestDto.toEntity(product));
        }

        return null;

    }

    @Transactional
    @Override
    public Void deleteProduct(String productUuid) {

        // 상품 uuid로 상품 조회
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
    public GetProductPreviewResponseDto getProductPreview(String productUuid) {
        return null;
    }


    @Override
    public GetProductByIdResponseDto findProductByUuid(String productUuid) {

        // 상품 Uuid로 상품, 썸네일, 상세내역 조회
        Product product = productRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        Optional<ProductDescription> productDescription =
                productDescriptionRepository.findByProductUuid(product.getProductUuid());

        List<ProductThumbnail> productThumbnailList = productThumbnailRepository.findByProductId(product.getId());

        List<GetProductThumbnailByIdResponseDto> getProductThumbnailByIdResponseDtoList= new ArrayList<>();

        // 상품 썸네일 리스트 엔티티 Dto로 옮겨담기
        for (ProductThumbnail productThumbnail : productThumbnailList) {
            getProductThumbnailByIdResponseDtoList.add(
                    GetProductThumbnailByIdResponseDto.from(productThumbnail)
            );
        }

        // 상품, 상품상세내역, 상품썸네일 객체를 조합하여 Entity to ResponseDto 생성
        return GetProductByIdResponseDto.from(
                product,
                productDescription,
                getProductThumbnailByIdResponseDtoList
        );
    }

    @Override
    public List<GetProductResponseDto> findAllProducts() {


        List<GetProductResponseDto> productDtoList = new ArrayList<>();

        List<Product> productList = productRepository.findAll();

        for (Product product : productList) {

            Optional<ProductDescription> productDescription = productDescriptionRepository.findByProductUuid(
                    product.getProductUuid()
            );

            productDtoList.add(
                    GetProductResponseDto.from(product, productDescription)
            );

        }

        return productDtoList;




    }




}
