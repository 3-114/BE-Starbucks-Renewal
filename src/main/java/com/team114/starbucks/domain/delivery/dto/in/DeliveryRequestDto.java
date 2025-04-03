package com.team114.starbucks.domain.delivery.dto.in;

import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.in.AddressVo;
import com.team114.starbucks.domain.delivery.vo.in.AliasVo;
import com.team114.starbucks.domain.delivery.vo.in.RecipientVo;
import com.team114.starbucks.domain.delivery.vo.in.PhoneNumberVo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
// 클라이언트 -> 서버
public class DeliveryRequestDto {

    private AliasVo alias;
    private RecipientVo recipient;
    private AddressVo address;
    private PhoneNumberVo phoneNumbers;
    private String deliveryMemo;
    private boolean defaultAddress;

    public Delivery toEntity(String deliveryUuid, String memberUuid) {
        return Delivery.builder()
                .deliveryUuid(deliveryUuid)
                .memberUuid(memberUuid)
                .alias(alias.getAlias())
                .recipient(recipient.getRecipient())
                .zoneCode(address.getZoneCode())
                .mainAddress(address.getMainAddress())
                .detailAddress(address.getDetailAddress())
                .phoneNumber1(phoneNumbers.getPhoneNumber1())
                .phoneNumber2(phoneNumbers.getPhoneNumber2())
                .deliveryMemo(deliveryMemo)
                .defaultAddress(defaultAddress)
                .active(true)
                .build();
    }
}