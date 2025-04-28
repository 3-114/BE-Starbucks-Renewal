package com.team114.starbucks.domain.product.dto.in;


import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.vo.in.CreateProductReqVo;
import com.team114.starbucks.domain.product.vo.in.CreateProductThumbnailReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class CreateProductReqDto {

    private String productName;
    private String brand;
    private Integer productPrice;
    private String productDescription;
    private Integer shippingFee;
    private ProductStatus productStatus;

    private List<CreateProductThumbnailReqDto> productThumbnailList;

    @Builder
    public CreateProductReqDto(
            String productName,
            String brand,
            Integer productPrice,
            String productDescription,
            Integer shippingFee,
            ProductStatus productStatus,
            List<CreateProductThumbnailReqDto> productThumbnailList
    ) {
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.shippingFee = shippingFee;
        this.productStatus = productStatus;
        this.productThumbnailList = productThumbnailList;
    }

    //vo -> dto
    public static CreateProductReqDto from(
            CreateProductReqVo vo
    ) {
        List<CreateProductThumbnailReqDto> productThumbnailList = new ArrayList<>();

        for (CreateProductThumbnailReqVo thumbnail : vo.getProductThumbnailList()) {
            productThumbnailList.add(CreateProductThumbnailReqDto.from(thumbnail));
        }

        return CreateProductReqDto.builder()
                .productName(vo.getProductName())
                .brand(vo.getBrand())
                .productPrice(vo.getProductPrice())
                .productDescription(vo.getProductDescription())
                .shippingFee(vo.getShippingFee())
                .productStatus(vo.getProductStatus())
                .productThumbnailList(productThumbnailList)
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