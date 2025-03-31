package com.team114.starbucks.domain.delivery.infrastructure;

import com.team114.starbucks.domain.delivery.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    @Modifying
    @Query("UPDATE Delivery d SET d.defaultAddress = false WHERE d.defaultAddress = true")
    void clearDefaultDelivery();
}