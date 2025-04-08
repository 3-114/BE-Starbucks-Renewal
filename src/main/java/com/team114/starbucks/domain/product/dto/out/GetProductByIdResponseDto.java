package com.team114.starbucks.domain.product.dto.out;


import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.entity.ProductDescription;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.vo.out.GetProductByIdResponseVo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
public class GetProductByIdResponseDto {

    private String productUuid;
    private String productName;
    private String brand;
    private Integer productPrice;
    private String productDescription;
    private Integer shippingFee;
    private ProductStatus productStatus;

    private List<GetProductThumbnailByIdResponseDto> getProductThumbnailByIdResponseDtoList;

    @Builder
    public GetProductByIdResponseDto(
            String productUuid, String productName, String brand, Integer productPrice, String productDescription, Integer shippingFee, ProductStatus productStatus
            , List<GetProductThumbnailByIdResponseDto> getProductThumbnailByIdResponseDtoList) {
        this.productUuid = productUuid;
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.shippingFee = shippingFee;
        this.productStatus = productStatus;
        this.getProductThumbnailByIdResponseDtoList = getProductThumbnailByIdResponseDtoList;
    }

    // dto <- entity
    public static GetProductByIdResponseDto from(
            Product product,
            Optional<ProductDescription> productDescription,
            List<GetProductThumbnailByIdResponseDto> getProductThumbnailByIdResponseDtoList
    ) {
        return GetProductByIdResponseDto.builder()
                .productUuid(product.getProductUuid())
                .productName(product.getProductName())
                .brand(product.getBrand())
                .productPrice(product.getProductPrice())
                .productDescription(productDescription.get().getProductDescription())
                .shippingFee(product.getShippingFee())
                .productStatus(product.getProductStatus())
                .getProductThumbnailByIdResponseDtoList(getProductThumbnailByIdResponseDtoList)
                .build();

    }



    // vo <- dto
    public GetProductByIdResponseVo toVo() {
        return GetProductByIdResponseVo.builder()
                .productUuid(productUuid)
                .productName(productName)
                .brand(brand)
                .productPrice(productPrice)
                .productDescription(productDescription)
                .shippingFee(shippingFee)
                .productStatus(productStatus)
                .getProductThumbnailByIdResponseDtoList(getProductThumbnailByIdResponseDtoList)
                .build();
    }



}
