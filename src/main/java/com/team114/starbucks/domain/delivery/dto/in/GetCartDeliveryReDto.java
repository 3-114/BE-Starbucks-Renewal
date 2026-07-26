package com.team114.starbucks.domain.delivery.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetCartDeliveryReDto {

    private String deliveryUuid;
    private String memberUuid;

    @Builder
    public GetCartDeliveryReDto(String deliveryUuid, String memberUuid) {
        this.deliveryUuid = deliveryUuid;
        this.memberUuid = memberUuid;
    }

    public static GetCartDeliveryReDto from(String deliveryUuid, String memberUuid) {
        return GetCartDeliveryReDto.builder()
                .deliveryUuid(deliveryUuid)
                .memberUuid(memberUuid)
                .build();
    }
}