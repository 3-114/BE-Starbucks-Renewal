package com.team114.starbucks.domain.product.dto.in;


import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.vo.in.CreateProductRequestVo;
import com.team114.starbucks.domain.product.vo.in.CreateProductThumbnailRequestVo;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CreateProductRequestDto {

    private String productName;
    private String brand;
    private Integer productPrice;
    private String description;
    private Integer shippingFee;
    private ProductStatus productStatus;

    private List<CreateThumbnailRequestDto> thumbnailList;

    @Builder
    public CreateProductRequestDto(
            String productName,
            String brand,
            Integer productPrice,
            String description,
            Integer shippingFee,
            ProductStatus productStatus,
            List<CreateThumbnailRequestDto> thumbnailList
    ) {
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
        this.description = description;
        this.shippingFee = shippingFee;
        this.productStatus = productStatus;
        this.thumbnailList = thumbnailList;
    }

    //vo -> dto
    public static CreateProductRequestDto from(
            CreateProductRequestVo vo
    ) {
        List<CreateThumbnailRequestDto> thumbnailList = new ArrayList<>();

        for (CreateProductThumbnailRequestVo thumbnail : vo.getThumbnailList()) {
            thumbnailList.add(CreateThumbnailRequestDto.from(thumbnail));
        }

        return CreateProductRequestDto.builder()
                .productName(vo.getProductName())
                .brand(vo.getBrand())
                .productPrice(vo.getProductPrice())
                .description(vo.getDescription())
                .shippingFee(vo.getShippingFee())
                .productStatus(vo.getProductStatus())
                .thumbnailList(thumbnailList)
                .build();
    }

    // dto -> entity
    public Product toEntity(String productUuid) {

        return Product.builder()
                .productUuid(productUuid)
                .productName(productName)
                .brand(brand)
                .productPrice(productPrice)
                .shippingFee(shippingFee)
                .productStatus(productStatus)
                .build();
    }




}
