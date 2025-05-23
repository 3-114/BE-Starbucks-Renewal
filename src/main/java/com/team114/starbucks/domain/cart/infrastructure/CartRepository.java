package com.team114.starbucks.domain.cart.infrastructure;

import com.team114.starbucks.domain.cart.entity.Cart;
import com.team114.starbucks.domain.cart.enums.CartType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByMemberUuid(String memberUuid);

    List<Cart> findByMemberUuidOrderBySelectedDesc(String memberUuid);

    List<Cart> findByMemberUuidAndCartTypeOrderBySelectedDesc(String memberUuid, CartType cartType);

    Optional<Cart> findByCartUuid(String cartUuid);

    void deleteByCartUuid(String cartUuid);

    void deleteAllByMemberUuid(String memberUuid);

    Long countByMemberUuidAndCartType(String memberUuid, CartType cartType);

    List<Cart> findByMemberUuidAndProductUuid(String memberUuid, String productUuid);

    void deleteAllByMemberUuidAndCartType(String memberUuid, CartType cartType);

}
