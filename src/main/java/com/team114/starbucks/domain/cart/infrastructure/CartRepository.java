package com.team114.starbucks.domain.cart.infrastructure;

import com.team114.starbucks.domain.cart.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
