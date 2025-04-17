package com.team114.starbucks.domain.delivery.dto.out;

import com.team114.starbucks.domain.delivery.dto.in.DeliverySelectedRequestDto;
import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.in.DeliverySelectedRequestVo;
import com.team114.starbucks.domain.delivery.vo.out.GetCartDeliveryResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetCartDeliveryResponseDto {

    private final String deliveryUuid;
    private final String alias;
    private final String recipient;
    private final String zoneCode;
    private final String mainAddress;
    private final String detailAddress;
    private final boolean defaultAddress;
    private final boolean isSelected;

    @Builder
    public GetCartDeliveryResponseDto(
            String deliveryUuid,
            String alias,
            String recipient,
            String zoneCode,
            String mainAddress,
            String detailAddress,
            boolean defaultAddress,
            boolean isSelected
    ) {
        this.deliveryUuid = deliveryUuid;
        this.alias = alias;
        this.recipient = recipient;
        this.zoneCode = zoneCode;
        this.mainAddress = mainAddress;
        this.detailAddress = detailAddress;
        this.defaultAddress = defaultAddress;
        this.isSelected = isSelected;
    }

    public static GetCartDeliveryResponseDto from(Delivery delivery) {
        return GetCartDeliveryResponseDto.builder()
                .deliveryUuid(delivery.getDeliveryUuid())
                .alias(delivery.getAlias())
                .recipient(delivery.getRecipient())
                .zoneCode(delivery.getZoneCode())
                .mainAddress(delivery.getMainAddress())
                .detailAddress(delivery.getDetailAddress())
                .defaultAddress(delivery.isDefaultAddress())
                .isSelected(delivery.isSelected())
                .build();
    }

    public GetCartDeliveryResponseVo toVo() {
        return GetCartDeliveryResponseVo.builder()
                .deliveryUuid(deliveryUuid)
                .alias(alias)
                .recipient(recipient)
                .zoneCode(zoneCode)
                .mainAddress(mainAddress)
                .detailAddress(detailAddress)
                .defaultAddress(defaultAddress)
                .isSelected(isSelected)
                .build();
    }
}