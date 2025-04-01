package com.team114.starbucks.domain.product.dto.in;


import com.team114.starbucks.domain.product.entity.Product;
import com.team114.starbucks.domain.product.enums.Brand;
import com.team114.starbucks.domain.product.enums.ProductStatus;
import com.team114.starbucks.domain.product.vo.in.ProductPostReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductPostReqDto {

    private Long id;
    private String uuid;
    private Brand brand;
    private String name;
    private Integer price;
    private String description;
    private ProductStatus productStatus;
    private Boolean optionFlag; //?
    private Integer shippingFee;

    @Builder
    public ProductPostReqDto(
            Long id,
            String uuid,
            Brand brand,
            String name,
            Integer price,
            String description,
            ProductStatus productStatus,
            Boolean optionFlag,
            Integer shippingFee
    ) {
        this.id = id;
        this.uuid = uuid;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.description = description;
        this.productStatus = productStatus;
        this.optionFlag = optionFlag;
        this.shippingFee = shippingFee;
    }

    public static ProductPostReqDto from(ProductPostReqVo productPostReqVo) {
        return ProductPostReqDto.builder()
                .id(productPostReqVo.getId())
                .uuid(productPostReqVo.getUuid())
                .brand(productPostReqVo.getBrand())
                .name(productPostReqVo.getName())
                .price(productPostReqVo.getPrice())
                .description(productPostReqVo.getDescription())
                .productStatus(productPostReqVo.getProductStatus())
                .optionFlag(productPostReqVo.getOptionFlag())
                .shippingFee(productPostReqVo.getShippingFee())
                .build();

    }

    public Product toEntity() {
        return Product.builder()
                .id(id)
                .uuid(uuid)
                .brand(brand)
                .name(name)
                .price(price)
                .description(description)
                .productStatus(productStatus)
                .optionFlag(optionFlag)
                .shippingFee(shippingFee)
                .build();
    }






}
