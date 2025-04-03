package com.team114.starbucks.domain.product.application;

import com.team114.starbucks.domain.product.dto.in.PostRequestDto;
import com.team114.starbucks.domain.product.dto.in.UpdateRequestDto;
import com.team114.starbucks.domain.product.dto.out.GetResponseDto;
import com.team114.starbucks.domain.product.dto.out.PostResponseDto;

import java.util.List;

public interface ProductService {

    List<GetResponseDto> getAllProducts();

    GetResponseDto getProduct(Long id);

    PostResponseDto saveProduct(PostRequestDto postRequestDto);


    devliery.update(dtd.getuuid());

    UpdateRequestDto updateProduct(UpdateRequestDto productUpdateRequestDto);


}
