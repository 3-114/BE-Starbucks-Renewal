package com.team114.starbucks.domain.delivery.dto.out;

import com.team114.starbucks.domain.delivery.entity.Delivery;
import com.team114.starbucks.domain.delivery.vo.out.AddressVo;
import com.team114.starbucks.domain.delivery.vo.out.AliasVo;
import com.team114.starbucks.domain.delivery.vo.out.PhoneNumberVo;
import com.team114.starbucks.domain.delivery.vo.out.RecipientVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeliveryResponseDto {

    private Long id;
    private String uuid;
    private AliasVo alias;
    private RecipientVo recipient;
    private AddressVo address;
    private PhoneNumberVo phoneNumbers;
    private String deliveryMemo;
    private boolean defaultAddress;

    public static DeliveryResponseDto fromEntity(Delivery delivery) {
        return DeliveryResponseDto.builder()
                .id(delivery.getId())
                .uuid(delivery.getDeliveryUuid())
                .alias(new AliasVo(delivery.getAlias()))
                .recipient(new RecipientVo(delivery.getRecipient()))
                .address(AddressVo.builder()
                        .zoneCode(delivery.getZoneCode())
                        .mainAddress(delivery.getMainAddress())
                        .detailAddress(delivery.getDetailAddress())
                        .build())
                .phoneNumbers(PhoneNumberVo.builder()
                        .phoneNumber1(delivery.getPhoneNumber1())
                        .phoneNumber2(delivery.getPhoneNumber2())
                        .build())
                .deliveryMemo(delivery.getDeliveryMemo())
                .defaultAddress(delivery.isDefaultAddress())
                .build();
    }
}