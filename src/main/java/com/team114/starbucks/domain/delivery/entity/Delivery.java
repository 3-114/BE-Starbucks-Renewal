package com.team114.starbucks.domain.delivery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Delivery {

    // 배송 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 배송 UUID
    private String uuid;

    // 주소
    private String address;

    // 배송지 별칭
    private String alias;

    // 연락처1
    private String primaryPhoneNumber;

    // 연락처2
    private String secondaryPhoneNumber;

    // 우편번호
    private Integer zoneCode;

    // 요청사항
    private String requestMemo;

    // 받는 사람 이름
    private String receiverName;

    @Builder
    public Delivery(
            Long id,
            String uuid,
            String address,
            String alias,
            String primaryPhoneNumber,
            String secondaryPhoneNumber,
            Integer zoneCode,
            String requestMemo,
            String receiverName
    ) {
        this.id = id;
        this.uuid = uuid;
        this.address = address;
        this.alias = alias;
        this.primaryPhoneNumber = primaryPhoneNumber;
        this.secondaryPhoneNumber = secondaryPhoneNumber;
        this.zoneCode = zoneCode;
        this.requestMemo = requestMemo;
        this.receiverName = receiverName;
    }
}
