package com.team114.starbucks.domain.delivery.dto.in;

import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.in.DeliveryCreateRequestVo;
import com.team114.starbucks.domain.delivery.vo.in.DeliveryUpdateRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DeliveryRequestDto {

    private final String memberUuid;
    private final String alias;
    private final String recipient;
    private final String zoneCode;
    private final String mainAddress;
    private final String detailAddress;
    private final String phoneNumber1;
    private final String phoneNumber2;
    private final String deliveryMemo;
    private final Boolean defaultAddress;

    @Builder
    public DeliveryRequestDto(String memberUuid,
                              String alias,
                              String recipient,
                              String zoneCode,
                              String mainAddress,
                              String detailAddress,
                              String phoneNumber1,
                              String phoneNumber2,
                              String deliveryMemo,
                              Boolean defaultAddress) {
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

    public static DeliveryRequestDto fromCreate(DeliveryCreateRequestVo vo, String memberUuid) {
        return DeliveryRequestDto.builder()
                .memberUuid(memberUuid)
                .alias(vo.getAlias())
                .recipient(vo.getRecipient())
                .zoneCode(vo.getZoneCode())
                .mainAddress(vo.getMainAddress())
                .detailAddress(vo.getDetailAddress())
                .phoneNumber1(vo.getPhoneNumber1())
                .phoneNumber2(vo.getPhoneNumber2())
                .deliveryMemo(vo.getDeliveryMemo())
                .defaultAddress(vo.isDefaultAddress())
                .build();
    }

    public static DeliveryRequestDto fromUpdate(String memberUuid, DeliveryUpdateRequestVo vo) {
        return DeliveryRequestDto.builder()
                .memberUuid(memberUuid)
                .alias(vo.getAlias())
                .recipient(vo.getRecipient())
                .zoneCode(vo.getZoneCode())
                .mainAddress(vo.getMainAddress())
                .detailAddress(vo.getDetailAddress())
                .phoneNumber1(vo.getPhoneNumber1())
                .phoneNumber2(vo.getPhoneNumber2())
                .deliveryMemo(vo.getDeliveryMemo())
                .defaultAddress(vo.isDefaultAddress())
                .build();
    }

    public Delivery toEntity(String deliveryUuid, String memberUuid) {
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
                .deleted(false)
                .active(true)
                .build();
    }
}