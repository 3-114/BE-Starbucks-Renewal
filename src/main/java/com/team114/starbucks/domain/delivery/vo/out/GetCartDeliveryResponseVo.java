package com.team114.starbucks.domain.delivery.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetCartDeliveryResponseVo {

    private final String deliveryUuid;
    private final String alias;
    private final String recipient;
    private final String zoneCode;
    private final String mainAddress;
    private final String detailAddress;
    private final String phoneNumber1;
    private final String phoneNumber2;
    private final String deliveryMemo;
    private final boolean defaultAddress;
    private final boolean isSelected;

    @Builder
    public GetCartDeliveryResponseVo(
            String deliveryUuid,
            String alias,
            String recipient,
            String zoneCode,
            String mainAddress,
            String detailAddress,
            String phoneNumber1,
            String phoneNumber2,
            String deliveryMemo,
            boolean defaultAddress,
            boolean isSelected
    ) {
        this.deliveryUuid = deliveryUuid;
        this.alias = alias;
        this.recipient = recipient;
        this.zoneCode = zoneCode;
        this.mainAddress = mainAddress;
        this.detailAddress = detailAddress;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.deliveryMemo = deliveryMemo;
        this.defaultAddress = defaultAddress;
        this.isSelected = isSelected;
    }
}