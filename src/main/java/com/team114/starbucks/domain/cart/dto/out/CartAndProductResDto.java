package com.team114.starbucks.domain.cart.dto.out;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.vo.out.CartAndProductResVo;
import com.team114.starbucks.domain.cart.vo.out.GetCartItemResVo;
import com.team114.starbucks.domain.product.dto.out.GetProductPreviewResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartAndProductResDto {

    private Long quantity;
    private Boolean selected;
    private String productName;
    private Integer productPrice;
    private String productThumbnailUrl;
    private Boolean isThumbnail;
    private Integer shippingFee;

    @Builder
    public CartAndProductResDto(
            Long quantity,
            Boolean selected,
            String productName,
            Integer productPrice,
            String productThumbnailUrl,
            Boolean isThumbnail,
            Integer shippingFee
    ) {
        this.quantity = quantity;
        this.selected = selected;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productThumbnailUrl = productThumbnailUrl;
        this.isThumbnail = isThumbnail;
        this.shippingFee = shippingFee;
    }

    public static CartAndProductResDto of(
            Cart cart,
            GetProductPreviewResponseDto getProductPreviewResponseDto
    ) {
        return CartAndProductResDto.builder()
                .quantity(cart.getQuantity())
                .selected(cart.getSelected())
                .productName(getProductPreviewResponseDto.getProductName())
                .productPrice(getProductPreviewResponseDto.getProductPrice())
                .productThumbnailUrl(getProductPreviewResponseDto.getProductThumbnailUrl())
                .isThumbnail(getProductPreviewResponseDto.getIsThumbnail())
                .shippingFee(getProductPreviewResponseDto.getShippingFee())
                .build();
    }

    public CartAndProductResVo toVo() {
        return CartAndProductResVo.builder()
                .quantity(quantity)
                .selected(selected)
                .productName(productName)
                .productPrice(productPrice)
                .productThumbnailUrl(productThumbnailUrl)
                .isThumbnail(isThumbnail)
                .shippingFee(shippingFee)
                .build();
    }
}
