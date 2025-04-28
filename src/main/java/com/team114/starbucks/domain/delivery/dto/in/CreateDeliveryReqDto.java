package com.team114.starbucks.domain.delivery.dto.in;

import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.in.CreateDeliveryReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateDeliveryReqDto {

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
    public CreateDeliveryReqDto(
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

    public static CreateDeliveryReqDto from(
            CreateDeliveryReqVo createDeliveryReqVo,
            String memberUuid
    ) {
        return CreateDeliveryReqDto.builder()
                .memberUuid(memberUuid)
                .alias(createDeliveryReqVo.getAlias())
                .recipient(createDeliveryReqVo.getRecipient())
                .zoneCode(createDeliveryReqVo.getZoneCode())
                .mainAddress(createDeliveryReqVo.getMainAddress())
                .detailAddress(createDeliveryReqVo.getDetailAddress())
                .phoneNumber1(createDeliveryReqVo.getPhoneNumber1())
                .phoneNumber2(createDeliveryReqVo.getPhoneNumber2())
                .deliveryMemo(createDeliveryReqVo.getDeliveryMemo())
                .defaultAddress(createDeliveryReqVo.isDefaultAddress())
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