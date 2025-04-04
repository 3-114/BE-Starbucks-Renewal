package com.team114.starbucks.domain.product.application;


import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.product.dto.in.CreateProductRequestDto;
import com.team114.starbucks.domain.product.dto.out.CreateProductResponseDto;
import com.team114.starbucks.domain.product.dto.out.GetByIdResponseDto;
import com.team114.starbucks.domain.product.dto.out.GetProductResponseDto;
import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    public final ProductRepository productRepository;

    @Transactional
    @Override
    public CreateProductResponseDto saveProduct(CreateProductRequestDto dto) {

        try {
            Product newPrduct = dto.toEntity(UUID.randomUUID().toString());

            Product savedProduct = productRepository.save(newPrduct);

            return CreateProductResponseDto.from(savedProduct);

        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_SAVE);
        }
    }


    @Override
    public GetByIdResponseDto findProductByUuid(String productUuid) {

        Product product = productRepository.findByProductUuid(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));


        return GetByIdResponseDto.from(product);
    }

    @Override
    public List<GetProductResponseDto> findAllProducts() {

        List<Product> productList = productRepository.findAll();

        List<GetProductResponseDto> dtoList = new ArrayList<>();

        for (Product product : productList) {
            dtoList.add(GetProductResponseDto.from(product));
        }

        return dtoList;
    }

}
