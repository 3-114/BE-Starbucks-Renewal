package com.team114.starbucks.domain.delivery.entity;

import com.team114.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)

// Soft Delete
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

    // Client가 삭제 요청한 컬럼
    @Builder.Default
    @Column(nullable = false)
    private Boolean deleted = false;

    // 현재 사용 중인 주소인지
    @Builder.Default
    @Column(nullable = false)
    private boolean active = true;

    // 사용자가 배송지를 삭제했을 때
    public void markAsDeleted() {
        this.deleted = true;
    }

    // 기존 배송지를 비활성화에서 기본 배송지를 바꿀 때
    public void deactivate() {
        this.active = false;
    }

    // 현재 배송지를 기본 배송지로 설정할 때
    public void activateAsDefault() {
        this.defaultAddress = true;
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