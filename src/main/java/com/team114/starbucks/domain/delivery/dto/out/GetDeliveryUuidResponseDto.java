package com.team114.starbucks.domain.delivery.dto.out;

import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.out.GetDeliveryUuidResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetDeliveryUuidResponseDto {

    private String deliveryUuid;

    @Builder
    public GetDeliveryUuidResponseDto(String deliveryUuid) {
        this.deliveryUuid = deliveryUuid;
    }

    public static GetDeliveryUuidResponseDto from(Delivery delivery) {
        return GetDeliveryUuidResponseDto.builder()
                .deliveryUuid(delivery.getDeliveryUuid())
                .build();
    }

    public GetDeliveryUuidResponseVo toVo() {
        return GetDeliveryUuidResponseVo.builder()
                .deliveryUuid(this.deliveryUuid)
                .build();
    }

}
