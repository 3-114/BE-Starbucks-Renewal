package com.team114.starbucks.domain.delivery.dto.out;

import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.out.GetCartDeliveryResVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetCartDeliveryResDto {

    private final String deliveryUuid;
    private final String alias;
    private final String recipient;
    private final String zoneCode;
    private final String mainAddress;
    private final String detailAddress;
    private final boolean defaultAddress;
    private final boolean isSelected;

    @Builder
    public GetCartDeliveryResDto(
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

    public static GetCartDeliveryResDto from(Delivery delivery) {
        return GetCartDeliveryResDto.builder()
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

    public GetCartDeliveryResVo toVo() {
        return GetCartDeliveryResVo.builder()
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