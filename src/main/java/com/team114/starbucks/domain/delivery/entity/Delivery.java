package com.team114.starbucks.domain.delivery.entity;

import com.team114.starbucks.domain.delivery.dto.in.DeliveryRequestDto;

import com.team114.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE delivery SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String memberUuid;

    @Column(nullable = false)
    private String deliveryUuid;

    @Comment("배송지 닉네임")
    @Column(length = 20)
    private String alias;

    @Comment("받는 분")
    @Column(nullable = false, length = 20)
    private String recipient;

    @Comment("우편번호")
    @Column(nullable = false, length = 5)
    private String zoneCode;

    @Comment("기본 주소")
    @Column(nullable = false, length = 100)
    private String mainAddress;

    @Comment("상세 주소")
    @Column(nullable = false, length = 100)
    private String detailAddress;

    @Column(nullable = false, length = 20)
    private String phoneNumber1;

    @Column(length = 20)
    private String phoneNumber2;

    @Column(length = 30)
    private String deliveryMemo;

    @Column(nullable = false)
    private boolean defaultAddress;

    @Builder.Default
    @Column(nullable = false)
    private Boolean deleted = false;

    @Builder.Default
    @Column(nullable = false)
    private boolean active = true;

    public void markAsDeleted() {
        this.deleted = true;
    }

    public void deactivate() {
        this.active = false;
    }

    @Builder
    public Delivery(
            Long id,
            String deliveryUuid,
            String memberUuid,
            String alias,
            String recipient,
            String zoneCode,
            String mainAddress,
            String detailAddress,
            String phoneNumber1,
            String phoneNumber2,
            String deliveryMemo,
            boolean defaultAddress,
            boolean deleted,
            boolean active
    ) {
        this.id = id;
        this.deliveryUuid = deliveryUuid;
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
        this.deleted = deleted;
        this.active = active;
    }

    // Delivery 엔티티
    public void activateAsDefault() {
        this.defaultAddress = true;
    }
}

