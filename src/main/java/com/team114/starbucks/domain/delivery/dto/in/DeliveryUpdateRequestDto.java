package com.team114.starbucks.domain.delivery.dto.in;

import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.in.DeliveryUpdateRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DeliveryUpdateRequestDto {

    private String deliveryUuid;
    private String memberUuid;
    private String alias;
    private String recipient;
    private String zoneCode;
    private String mainAddress;
    private String detailAddress;
    private String phoneNumber1;
    private String phoneNumber2;
    private String deliveryMemo;
    private boolean defaultAddress;

    @Builder
    public DeliveryUpdateRequestDto(
            String deliveryUuid,
            String memberUuid,
            String alias,
            String recipient,
            String zoneCode,
            String mainAddress,
            String detailAddress,
            String phoneNumber1,
            String phoneNumber2,
            String deliveryMemo,
            boolean defaultAddress
    ) {
        this.deliveryUuid = deliveryUuid;
        this.memberUuid = memberUuid;
        this.alias = alias;
        this.recipient = recipient;
        this.zoneCode = zoneCode;
        this.mainAddress = mainAddress;
        this.detailAddress = detailAddress;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.deliveryMemo = deliveryMemo;
        this.defaultAddress = defaultAddress;
    }

    public static DeliveryUpdateRequestDto from(
            DeliveryUpdateRequestVo deliveryUpdateRequestVo, String memberUuid, String deliveryUuid
    ) {
        return DeliveryUpdateRequestDto.builder()
                .deliveryUuid(deliveryUuid)
                .memberUuid(memberUuid)
                .alias(deliveryUpdateRequestVo.getAlias())
                .recipient(deliveryUpdateRequestVo.getRecipient())
                .zoneCode(deliveryUpdateRequestVo.getZoneCode())
                .mainAddress(deliveryUpdateRequestVo.getMainAddress())
                .detailAddress(deliveryUpdateRequestVo.getDetailAddress())
                .phoneNumber1(deliveryUpdateRequestVo.getPhoneNumber1())
                .phoneNumber2(deliveryUpdateRequestVo.getPhoneNumber2())
                .deliveryMemo(deliveryUpdateRequestVo.getDeliveryMemo())
                .defaultAddress(deliveryUpdateRequestVo.isDefaultAddress())
                .build();
    }

    public Delivery toEntity(Delivery delivery) {
        return Delivery.builder()
                .id(delivery.getId())
                .deliveryUuid(delivery.getDeliveryUuid())
                .memberUuid(memberUuid)
                .alias(alias)
                .recipient(recipient)
                .zoneCode(zoneCode)
                .mainAddress(mainAddress)
                .detailAddress(detailAddress)
                .phoneNumber1(phoneNumber1)
                .phoneNumber2(phoneNumber2)
                .deliveryMemo(deliveryMemo)
                .defaultAddress(defaultAddress)
                .build();
    }
}