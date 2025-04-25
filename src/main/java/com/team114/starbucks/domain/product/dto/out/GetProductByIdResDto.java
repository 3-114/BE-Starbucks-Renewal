package com.team114.starbucks.domain.product.dto.out;


import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.vo.out.GetProductByIdResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GetProductByIdResDto {

    private String productUuid;
    private String productName;
    private String brand;
    private Integer productPrice;
    private String productDescription;
    private Integer shippingFee;
    private ProductStatus productStatus;

    private List<GetProductThumbnailByIdResDto> getProductThumbnailByIdResDtoList;

    @Builder
    public GetProductByIdResDto(
            String productUuid, String productName, String brand, Integer productPrice, String productDescription, Integer shippingFee, ProductStatus productStatus
            , List<GetProductThumbnailByIdResDto> getProductThumbnailByIdResDtoList) {
        this.productUuid = productUuid;
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.shippingFee = shippingFee;
        this.productStatus = productStatus;
        this.getProductThumbnailByIdResDtoList = getProductThumbnailByIdResDtoList;
    }

    public static GetProductByIdResDto from(
            Product product,
            List<GetProductThumbnailByIdResDto> getProductThumbnailByIdResDtoList
    ) {
        return GetProductByIdResDto.builder()
                .productUuid(product.getProductUuid())
                .productName(product.getProductName())
                .brand(product.getBrand())
                .productPrice(product.getProductPrice())
                .shippingFee(product.getShippingFee())
                .productStatus(product.getProductStatus())
                .getProductThumbnailByIdResponseDtoList(getProductThumbnailByIdResDtoList)
                .build();
    }

    public GetProductByIdResVo toVo() {
        return GetProductByIdResVo.builder()
                .productUuid(productUuid)
                .productName(productName)
                .brand(brand)
                .productPrice(productPrice)
                .shippingFee(shippingFee)
                .productStatus(productStatus)
                .getProductThumbnailByIdResponseDtoList(getProductThumbnailByIdResDtoList)
                .build();
    }

}