package com.team114.starbucks.domain.product.vo.out;

import com.team114.starbucks.domain.product.dto.out.GetProductThumbnailByIdResponseDto;
import com.team114.starbucks.domain.product.entity.ProductThumbnail;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class GetProductByIdResponseVo {

    private String productUuid;
    private String productName;
    private String brand;
    private Integer productPrice;
    private String productDescription;
    private Integer shippingFee;
    private ProductStatus productStatus;
    private List<GetProductThumbnailByIdResponseDto>
    getProductThumbnailByIdResponseDtoList;

    @Builder
    public GetProductByIdResponseVo(
            String productUuid, String productName, String brand, Integer productPrice, String productDescription, Integer shippingFee, ProductStatus productStatus,
            List<GetProductThumbnailByIdResponseDto> getProductThumbnailByIdResponseDtoList) {
        this.productUuid = productUuid;
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.shippingFee = shippingFee;
        this.productStatus = productStatus;
        this.getProductThumbnailByIdResponseDtoList = getProductThumbnailByIdResponseDtoList;
    }

}
