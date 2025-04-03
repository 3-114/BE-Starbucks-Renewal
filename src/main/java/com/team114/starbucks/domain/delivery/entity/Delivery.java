package com.team114.starbucks.domain.delivery.entity;

import com.team114.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.SQLDelete;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE delivery SET deleted = true WHERE id = ?")
public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String memberUuid;

    @Column(nullable = false, unique = true)
    private String deliveryUuid;

    @Column(length = 20)
    private String alias;

    @Column(nullable = false, length = 20)
    private String recipient;

    @Column(nullable = false, length = 10)
    private String zoneCode;

    @Column(nullable = false, length = 100)
    private String mainAddress;

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

    @Column(nullable = false)
    private Boolean deleted;

    @Column(nullable = false)
    private boolean active;

    // 사용자가 배송지를 삭제했을 때
    public void markAsDeleted() {
        this.deleted = true;
    }

    // 현재 배송지를 기본 배송지로 설정할 때
    public void activateAsDefault() {
        this.defaultAddress = true;
    }

    public void deactivate() {
        this.active = false;
        this.defaultAddress = false;
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
}