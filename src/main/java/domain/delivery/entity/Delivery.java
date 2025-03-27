package domain.delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String alias;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 5)
    private String zipcode;

    @Column(nullable = false, length = 100)
    private String mainAddress;

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
}