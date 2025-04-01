package com.team114.starbucks.domain.delivery.vo.in;

import com.team114.starbucks.domain.delivery.dto.in.DeliveryRequestDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DeliveryRequestVo {

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
    public DeliveryRequestVo(String alias, String recipient, String zoneCode,
                             String mainAddress, String detailAddress,
                             String phoneNumber1, String phoneNumber2,
                             String deliveryMemo, boolean defaultAddress) {
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

    // DTO 변환 메서드
    public static DeliveryRequestDto toDto(DeliveryRequestVo vo) {
        return DeliveryRequestDto.builder()
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
}