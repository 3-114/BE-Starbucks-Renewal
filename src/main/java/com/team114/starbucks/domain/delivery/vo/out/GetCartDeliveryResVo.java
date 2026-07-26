package com.team114.starbucks.domain.delivery.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetCartDeliveryResVo {

    private final String deliveryUuid;
    private final String alias;
    private final String recipient;
    private final String zoneCode;
    private final String mainAddress;
    private final String detailAddress;
    private final boolean defaultAddress;
    private final boolean isSelected;

    @Builder
    public GetCartDeliveryResVo(
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
}