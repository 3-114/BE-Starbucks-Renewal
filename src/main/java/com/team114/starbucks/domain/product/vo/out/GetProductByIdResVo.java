package com.team114.starbucks.domain.product.vo.out;

import com.team114.starbucks.domain.product.dto.out.GetProductThumbnailByIdResDto;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GetProductByIdResVo {

    private String productUuid;
    private String productName;
    private String brand;
    private Integer productPrice;
    private String productDescription;
    private Integer shippingFee;
    private ProductStatus productStatus;
    private List<GetProductThumbnailByIdResDto> thumbnailList;

    @Builder
    public GetProductByIdResVo(
            String productUuid, String productName, String brand, Integer productPrice, String productDescription, Integer shippingFee, ProductStatus productStatus,
            List<GetProductThumbnailByIdResDto> getProductThumbnailByIdResDtoList) {
        this.productUuid = productUuid;
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.shippingFee = shippingFee;
        this.productStatus = productStatus;
        this.thumbnailList = getProductThumbnailByIdResDtoList;
    }

}