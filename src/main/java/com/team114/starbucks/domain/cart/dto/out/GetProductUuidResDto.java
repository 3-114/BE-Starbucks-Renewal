package com.team114.starbucks.domain.cart.dto.out;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.vo.out.GetProductUuidResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetProductUuidResDto {

    private String productUuid;

    @Builder
    public GetProductUuidResDto(String productUuid) {
        this.productUuid = productUuid;
    }

    public static GetProductUuidResDto from(Cart cart) {
        return GetProductUuidResDto.builder()
                .productUuid(cart.getProductUuid())
                .build();
    }

    public GetProductUuidResVo toVo() {
        return GetProductUuidResVo.builder()
                .productUuid(productUuid)
                .build();
    }
}
