package com.team114.starbucks.domain.delivery.dto.in;

import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.in.DeliveryUpdateRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DeliveryUpdateRequestDto {

    private final String deliveryUuid;
    private final String memberUuid;
    private final String alias;
    private final String recipient;
    private final String zoneCode;
    private final String mainAddress;
    private final String detailAddress;
    private final String phoneNumber1;
    private final String phoneNumber2;
    private final String deliveryMemo;
    private final boolean defaultAddress;

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
            DeliveryUpdateRequestVo deliveryUpdateRequestVo
    ) {
        return DeliveryUpdateRequestDto.builder()
                .deliveryUuid(deliveryUpdateRequestVo.getDeliveryUuid())
                .memberUuid(deliveryUpdateRequestVo.getMemberUuid())
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

    public Delivery toEntity(Long id) {
        return Delivery.builder()
                .id(id)
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