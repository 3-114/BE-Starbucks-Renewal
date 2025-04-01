package com.team114.starbucks.domain.delivery.dto.out;

import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.out.DeliveryResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DeliveryResponseDto {

    private String deliveryUuid;
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
    public DeliveryResponseDto(String deliveryUuid, String alias, String recipient,
                               String zoneCode, String mainAddress, String detailAddress,
                               String phoneNumber1, String phoneNumber2,
                               String deliveryMemo, boolean defaultAddress) {
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
    }

    // Entity → DTO 변환 메서드
    public static DeliveryResponseDto fromEntity(Delivery delivery) {
        return DeliveryResponseDto.builder()
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
                .build();
    }

    // DeliveryResponseDto.java
    public DeliveryResponseVo toVo() {
        return DeliveryResponseVo.builder()
                .deliveryUuid(this.deliveryUuid)
                .alias(this.alias)
                .recipient(this.recipient)
                .zoneCode(this.zoneCode)
                .mainAddress(this.mainAddress)
                .detailAddress(this.detailAddress)
                .phoneNumber1(this.phoneNumber1)
                .phoneNumber2(this.phoneNumber2)
                .deliveryMemo(this.deliveryMemo)
                .defaultAddress(this.defaultAddress)
                .build();
    }
}