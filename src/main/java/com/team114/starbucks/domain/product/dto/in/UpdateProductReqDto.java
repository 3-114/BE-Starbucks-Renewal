package com.team114.starbucks.domain.product.dto.in;

import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.vo.in.UpdateProductReqVo;
import com.team114.starbucks.domain.product.vo.in.UpdateProductThumbnailReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class UpdateProductReqDto {

    private String productUuid;
    private String productName;
    private String brand;
    private Integer productPrice;
    private Integer shippingFee;
    private ProductStatus productStatus;

    private List<UpdateProductThumbnailReqDto> productThumbnailList;

    @Builder
    public UpdateProductReqDto(
            String productUuid, String productName, String brand, Integer productPrice, Integer shippingFee, ProductStatus productStatus,
            List<UpdateProductThumbnailReqDto> productThumbnailList) {
        this.productUuid = productUuid;
        this.productName = productName;
        this.brand = brand;
        this.productPrice = productPrice;
        this.shippingFee = shippingFee;
        this.productStatus = productStatus;
        this.productThumbnailList = productThumbnailList;
    }

    public static UpdateProductReqDto from(UpdateProductReqVo vo) {
        List<UpdateProductThumbnailReqDto> thumbnailList = new ArrayList<>();

        for (UpdateProductThumbnailReqVo thumbnail : vo.getProductThumbnailList()) {
            thumbnailList.add(UpdateProductThumbnailReqDto.from(thumbnail));
        }

        return UpdateProductReqDto.builder()
                .productUuid(vo.getProductUuid())
                .productName(vo.getProductName())
                .brand(vo.getBrand())
                .productPrice(vo.getProductPrice())
                .shippingFee(vo.getShippingFee())
                .productStatus(vo.getProductStatus())
                .productThumbnailList(thumbnailList)
                .build();
    }

    public Product updateProduct(Product product) {
        return Product.builder()
                .id(product.getId())
                .productUuid(product.getProductUuid())
                .brand(this.brand)
                .productName(this.productName)
                .productPrice(this.productPrice)
                .shippingFee(this.shippingFee)
                .productStatus(this.productStatus)
                .build();
    }

}