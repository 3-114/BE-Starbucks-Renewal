package com.team114.starbucks.domain.product.application.ProductDescription;

import com.team114.starbucks.domain.product.application.ProductService;
import com.team114.starbucks.domain.product.dto.in.ProductDescription.CreateProductDescriptionRequestDto;
import com.team114.starbucks.domain.product.dto.in.ProductDescription.UpdateProductDescriptionRequestDto;
import com.team114.starbucks.domain.product.dto.out.ProductDescription.GetProductDescriptionAllResDto;
import com.team114.starbucks.domain.product.dto.out.ProductDescription.GetProductDescriptionByProductUuidResDto;
import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.entity.ProductDescription;
import com.team114.starbucks.domain.product.infrastructure.ProductDescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

    private final ProductDescriptionRepository productDescriptionRepository;
    private final ProductService productService;

    @Override
    public void createProductDescription(CreateProductDescriptionRequestDto createProductDescriptionRequestDto) {

        if (!productService.checkProductExist(createProductDescriptionRequestDto.getProductUuid())) {
            throw new IllegalArgumentException("Product not found with UUID: " + createProductDescriptionRequestDto.getProductUuid());
        }

        if (productDescriptionRepository.findByProductUuid(createProductDescriptionRequestDto.getProductUuid()).isPresent()) {
            throw new IllegalArgumentException("ProductDescription already exists with UUID: " + createProductDescriptionRequestDto.getProductUuid());
        }

        productDescriptionRepository.save(createProductDescriptionRequestDto.toEntity(createProductDescriptionRequestDto.getProductUuid()));
    }

    @Override
    public void updateProductDescription(UpdateProductDescriptionRequestDto updateProductDescriptionRequestDto) {

        if (!productService.checkProductExist(updateProductDescriptionRequestDto.getProductUuid())) {
            throw new IllegalArgumentException("Product not found with UUID: " + updateProductDescriptionRequestDto.getProductUuid());
        }

        productDescriptionRepository.save(updateProductDescriptionRequestDto.toEntity(productDescriptionRepository.findByProductUuid(updateProductDescriptionRequestDto.getProductUuid())
                .orElseThrow(() -> new IllegalArgumentException("ProductDescription not found with UUID: " + updateProductDescriptionRequestDto.getProductUuid()))));

    }

    @Override
    public GetProductDescriptionByProductUuidResDto getProductDescriptionByProductUuid(String productUuid) {

        return GetProductDescriptionByProductUuidResDto.from(productDescriptionRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new IllegalArgumentException("ProductDescription not found with UUID: " + productUuid)));
    }

    @Override
    public List<GetProductDescriptionAllResDto> getProductDescriptionAll() {

        return productDescriptionRepository.findAll().stream().map(GetProductDescriptionAllResDto::from).toList();
    }


}
