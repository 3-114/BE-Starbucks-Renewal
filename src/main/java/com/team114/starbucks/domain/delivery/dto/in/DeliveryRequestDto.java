package com.team114.starbucks.domain.delivery.dto.in;

import com.team114.starbucks.domain.delivery.vo.in.NameVo;
import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.in.AddressVo;
import com.team114.starbucks.domain.delivery.vo.in.AliasVo;
import com.team114.starbucks.domain.delivery.vo.in.PhoneNumberVo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeliveryRequestDto {

    private AliasVo alias;
    private AddressVo address;
    private PhoneNumberVo phoneNumbers;
    private String deliveryMemo;
    private boolean defaultAddress;
    private NameVo name;

    public Delivery toEntity(String uuid) {
        return Delivery.builder()
                .uuid(uuid)
                .alias(alias.getAlias())
                .zoneCode(address.getZoneCode())
                .mainAddress(address.getMainAddress())
                .detailAddress(address.getDetailAddress())
                .phoneNumber1(phoneNumbers.getPhoneNumber1())
                .phoneNumber2(phoneNumbers.getPhoneNumber2())
                .deliveryMemo(deliveryMemo)
                .defaultAddress(defaultAddress)
                .build();
    }
}