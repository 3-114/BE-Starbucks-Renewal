package com.team114.starbucks.domain.delivery.dto.out;

import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.out.GetAllDeliveryUuidResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetDeliveryUuidResDto {

    private String deliveryUuid;

    @Builder
    public GetDeliveryUuidResDto(String deliveryUuid) {
        this.deliveryUuid = deliveryUuid;
    }

    public static GetDeliveryUuidResDto from(Delivery delivery) {
        return GetDeliveryUuidResDto.builder()
                .deliveryUuid(delivery.getDeliveryUuid())
                .build();
    }

    public GetAllDeliveryUuidResVo toVo() {
        return GetAllDeliveryUuidResVo.builder()
                .deliveryUuid(this.deliveryUuid)
                .build();
    }

}
