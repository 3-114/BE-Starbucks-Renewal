package com.team114.starbucks.domain.delivery.dto.out;

import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.out.GetSelectedDeliveryResVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetDeliverySelectedReDto {

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
    public GetDeliverySelectedReDto(
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

    public static GetDeliverySelectedReDto from(Delivery delivery) {
        return GetDeliverySelectedReDto.builder()
                .deliveryUuid(delivery.getDeliveryUuid())
                .alias(delivery.getAlias())
                .recipient(delivery.getRecipient())
                .zoneCode(delivery.getZoneCode())
                .mainAddress(delivery.getMainAddress())
                .detailAddress(delivery.getDetailAddress())
                .phoneNumber1(delivery.getPhoneNumber1())
                .phoneNumber2(delivery.getPhoneNumber2())
                .deliveryMemo(delivery.getDeliveryMemo())
                .defaultAddress(delivery.isDefaultAddress())
                .isSelected(delivery.isSelected())
                .build();
    }

    public GetSelectedDeliveryResVo toVo() {
        return GetSelectedDeliveryResVo.builder()
                .deliveryUuid(deliveryUuid)
                .alias(alias)
                .recipient(recipient)
                .zoneCode(zoneCode)
                .mainAddress(mainAddress)
                .detailAddress(detailAddress)
                .phoneNumber1(phoneNumber1)
                .phoneNumber2(phoneNumber2)
                .deliveryMemo(deliveryMemo)
                .defaultAddress(defaultAddress)
                .isSelected(isSelected)
                .build();
    }
}
