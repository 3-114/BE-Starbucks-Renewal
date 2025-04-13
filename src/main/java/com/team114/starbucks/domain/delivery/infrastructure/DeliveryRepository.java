package com.team114.starbucks.domain.delivery.infrastructure;

import com.team114.starbucks.domain.delivery.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    // 특정 회원의 배송지 전체 조회
    List<Delivery> findAllByMemberUuid(String memberUuid);

    // 배송지 UUID로 단일 조회 (soft delete가 적용되어 있으므로 deleted = false 조건 자동 포함)
    Optional<Delivery> findByDeliveryUuid(String deliveryUuid);

    Optional<Delivery> findByMemberUuidAndDefaultAddressTrue(String memberUuid);

    List<Delivery> findByMemberUuid(String memberUuid);

    Optional<Delivery> findByMemberUuidAndIsSelectedTrue(String memberUuid);
}