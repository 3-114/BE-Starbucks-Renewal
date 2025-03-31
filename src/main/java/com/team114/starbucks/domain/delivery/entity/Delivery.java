package com.team114.starbucks.domain.delivery.entity;

import com.team114.starbucks.domain.delivery.dto.in.DeliveryRequestDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    @Comment("배송지 닉네임")
    @Column(length = 20)
    private String alias;

    @Comment("받는 분")
    @Column(nullable = false, length = 20)
    private String name;

    @Comment("우편번호")
    @Column(nullable = false, length = 5)
    private String zoneCode;

    @Comment("기본 주소")
    @Column(nullable = false, length = 100)
    private String mainAddress;

    @Comment("상세 주소")
    @Column(nullable = false, length = 100)
    private String detailAddress;

    @Column(nullable = false, length = 11)
    private String phoneNumber1;

    @Column(length = 11)
    private String phoneNumber2;

    @Column(length = 30)
    private String deliveryMemo;

    // 기본 배송지 여부
    @Column(nullable = false)
    private boolean defaultAddress;


    @Builder
    public Delivery (
            Long id,
            String uuid,
            String alias,
            String name,
            String zoneCode,
            String mainAddress,
            String detailAddress,
            String phoneNumber1,
            String phoneNumber2,
            String deliveryMemo,
            boolean defaultAddress
    ) {
        this.id = id;
        this.uuid = uuid;
        this.alias = alias;
        this.name = name;
        this.zoneCode = zoneCode;
        this.mainAddress = mainAddress;
        this.detailAddress = detailAddress;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.deliveryMemo = deliveryMemo;
        this.defaultAddress = defaultAddress;
    }

    // 배송지 수정
    public void updateFrom(DeliveryRequestDto dto) {
        this.alias = dto.getAlias().getAlias();
        this.name = dto.getName().getName();
        this.zoneCode = dto.getAddress().getZoneCode();
        this.mainAddress = dto.getAddress().getMainAddress();
        this.detailAddress = dto.getAddress().getDetailAddress();
        this.phoneNumber1 = dto.getPhoneNumbers().getPhoneNumber1();
        this.phoneNumber2 = dto.getPhoneNumbers().getPhoneNumber2();
        this.deliveryMemo = dto.getDeliveryMemo();
        this.defaultAddress = dto.isDefaultAddress();
    }

    // 기본 배송지 설정
    public void setAsDefault() {
        this.defaultAddress = true;
    }
}
