package com.team114.starbucks.domain.delivery.dto.in;

import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.in.DeliveryCreateRequestVo;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class DeliveryCreateRequestDto {

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
    public DeliveryCreateRequestDto(
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

    public static DeliveryCreateRequestDto from(
            DeliveryCreateRequestVo deliveryCreateRequestVo,
            String memberUuid
    ) {
        return DeliveryCreateRequestDto.builder()
                .memberUuid(memberUuid)
                .alias(deliveryCreateRequestVo.getAlias())
                .recipient(deliveryCreateRequestVo.getRecipient())
                .zoneCode(deliveryCreateRequestVo.getZoneCode())
                .mainAddress(deliveryCreateRequestVo.getMainAddress())
                .detailAddress(deliveryCreateRequestVo.getDetailAddress())
                .phoneNumber1(deliveryCreateRequestVo.getPhoneNumber1())
                .phoneNumber2(deliveryCreateRequestVo.getPhoneNumber2())
                .deliveryMemo(deliveryCreateRequestVo.getDeliveryMemo())
                .defaultAddress(deliveryCreateRequestVo.isDefaultAddress())
                .build();
    }

    public Delivery toEntity(String deliveryUuid, boolean defaultAddress) {
        return Delivery.builder()
                .deliveryUuid(deliveryUuid)
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