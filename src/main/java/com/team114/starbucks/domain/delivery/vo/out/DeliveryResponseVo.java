package com.team114.starbucks.domain.delivery.vo.out;

import com.team114.starbucks.domain.delivery.dto.out.DeliveryResponseDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DeliveryResponseVo {

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
    public DeliveryResponseVo(String deliveryUuid, String alias, String recipient,
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

    // DTO → VO 변환 메서드
    public static DeliveryResponseVo from(DeliveryResponseDto dto) {
        return DeliveryResponseVo.builder()
                .deliveryUuid(dto.getDeliveryUuid())
                .alias(dto.getAlias())
                .recipient(dto.getRecipient())
                .zoneCode(dto.getZoneCode())
                .mainAddress(dto.getMainAddress())
                .detailAddress(dto.getDetailAddress())
                .phoneNumber1(dto.getPhoneNumber1())
                .phoneNumber2(dto.getPhoneNumber2())
                .deliveryMemo(dto.getDeliveryMemo())
                .defaultAddress(dto.isDefaultAddress())
                .build();
    }
}