package com.team114.starbucks.domain.delivery.dto.in;

import com.team114.starbucks.domain.delivery.vo.in.CartDeliveryRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CartDeliveryRequestDto {

    private String deliveryUuid;
    private String memberUuid;

    @Builder
    public CartDeliveryRequestDto(String deliveryUuid, String memberUuid) {
        this.deliveryUuid = deliveryUuid;
        this.memberUuid = memberUuid;
    }

    public static CartDeliveryRequestDto from(CartDeliveryRequestVo cartDeliveryRequestVo, String memberUuid) {
        return CartDeliveryRequestDto.builder()
                .deliveryUuid(cartDeliveryRequestVo.getDeliveryUuid())
                .memberUuid(memberUuid)
                .build();
    }

}
