package com.team114.starbucks.domain.product.application;


import com.team114.starbucks.domain.product.dto.out.ProductResponseDto;
import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.infrastructure.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public List<ProductResponseDto> getAllProducts() {

        List<Product> productList = productRepository.findAll();

        List<ProductResponseDto> responseList =  new ArrayList<>();

        for (Product product : productList) {
            ProductResponseDto dto = ProductResponseDto.from(product);
            responseList.add(dto);
        }

        return responseList;
    }


}
