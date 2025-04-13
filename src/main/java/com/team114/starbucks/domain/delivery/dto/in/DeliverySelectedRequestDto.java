package com.team114.starbucks.domain.delivery.dto.in;

import com.team114.starbucks.domain.delivery.vo.in.DeliverySelectedRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DeliverySelectedRequestDto {

    private String deliveryUuid;
    private String memberUuid;

    @Builder
    public DeliverySelectedRequestDto(String deliveryUuid, String memberUuid) {
        this.deliveryUuid = deliveryUuid;
        this.memberUuid = memberUuid;
    }

    public static DeliverySelectedRequestDto from(
            DeliverySelectedRequestVo deliverySelectedRequestVo,
            String memberUuid
    ) {
        return DeliverySelectedRequestDto.builder()
                .deliveryUuid(deliverySelectedRequestVo.getDeliveryUuid())
                .memberUuid(memberUuid)
                .build();
    }

}
