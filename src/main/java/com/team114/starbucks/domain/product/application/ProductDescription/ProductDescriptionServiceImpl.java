package com.team114.starbucks.domain.product.application.ProductDescription;

import com.team114.starbucks.domain.product.application.ProductService;
import com.team114.starbucks.domain.product.dto.in.ProductDescription.CreateProductDescriptionReqDto;
import com.team114.starbucks.domain.product.dto.in.ProductDescription.UpdateProductDescriptionReqDto;
import com.team114.starbucks.domain.product.dto.out.ProductDescription.GetAllProductDescriptionResDto;
import com.team114.starbucks.domain.product.dto.out.ProductDescription.GetProductDescriptionByProductUuidResDto;
import com.team114.starbucks.domain.product.infrastructure.ProductDescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

    private final ProductDescriptionRepository productDescriptionRepository;
    private final ProductService productService;

    @Override
    public void createProductDescription(CreateProductDescriptionReqDto createProductDescriptionReqDto) {
        if (!productService.checkProductExist(createProductDescriptionReqDto.getProductUuid())) {
            throw new IllegalArgumentException("Product not found with UUID: " + createProductDescriptionReqDto.getProductUuid());
        }
        if (productDescriptionRepository.findByProductUuid(createProductDescriptionReqDto.getProductUuid()).isPresent()) {
            throw new IllegalArgumentException("ProductDescription already exists with UUID: " + createProductDescriptionReqDto.getProductUuid());
        }

        productDescriptionRepository.save(createProductDescriptionReqDto.toEntity(createProductDescriptionReqDto.getProductUuid()));
    }

    @Override
    public void updateProductDescription(UpdateProductDescriptionReqDto updateProductDescriptionReqDto) {
        if (!productService.checkProductExist(updateProductDescriptionReqDto.getProductUuid())) {
            throw new IllegalArgumentException("Product not found with UUID: " + updateProductDescriptionReqDto.getProductUuid());
        }

        productDescriptionRepository.save(updateProductDescriptionReqDto.toEntity(productDescriptionRepository.findByProductUuid(updateProductDescriptionReqDto.getProductUuid())
                .orElseThrow(() -> new IllegalArgumentException("ProductDescription not found with UUID: " + updateProductDescriptionReqDto.getProductUuid()))));
    }

    @Override
    public GetProductDescriptionByProductUuidResDto getProductDescriptionByProductUuid(String productUuid) {

        return GetProductDescriptionByProductUuidResDto.from(productDescriptionRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new IllegalArgumentException("ProductDescription not found with UUID: " + productUuid)));
    }

    @Override
    public List<GetAllProductDescriptionResDto> getProductDescriptionAll() {

        return productDescriptionRepository.findAll().stream().map(GetAllProductDescriptionResDto::from).toList();
    }

}