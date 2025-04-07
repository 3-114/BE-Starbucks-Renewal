package com.team114.starbucks.domain.cart.infrastructure;

import com.team114.starbucks.domain.cart.entity.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {

    @Query( "SELECT p.brand, p.productName, p.productPrice," +
            "o.color, o.size, o.optionPrice, o.discountRate," +
            "c.quantity, c.selected, c.valid " +
            "FROM Cart c " +
            "JOIN Product p ON c.productUuid = p.productUuid " +
            "JOIN Option o ON c.optionId = o.optionId " +
            "WHERE c.memberUuid = :memberUuid")
    Page<Cart> findCartItems(String memberUuid, Pageable pageable);
}
