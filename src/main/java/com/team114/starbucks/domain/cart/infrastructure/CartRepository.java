package com.team114.starbucks.domain.cart.infrastructure;

import com.team114.starbucks.domain.cart.dto.out.GetAllCartItemsResDto;
import com.team114.starbucks.domain.cart.dto.out.GetCartItemResDto;
import com.team114.starbucks.domain.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

//    @Query( "SELECT p.brand, p.productName, p.productPrice," +
//            "o.color, o.size, o.optionPrice, o.discountRate," +
//            "c.quantity, c.selected, c.valid " +
//            "FROM Cart c " +
//            "JOIN Product p ON c.productUuid = p.productUuid " +
//            "JOIN Option o ON c.optionId = o.optionId " +
//            "WHERE c.memberUuid = :memberUuid")
    @Query("SELECT new com.team114.starbucks.domain.cart.dto.out.GetAllCartItemsResDto(" +
            "p.productName, p.productPrice, " +
            "o.color.colorName, o.size.sizeName, o.optionPrice, o.discountRate, " +
            "c.quantity, c.selected, c.valid) " +
            "FROM Cart c " +
            "JOIN Product p ON c.productUuid = p.productUuid " +
            "JOIN Option o ON c.optionId = o.optionId " +
            "WHERE c.memberUuid = :memberUuid")
    List<GetAllCartItemsResDto> findCartItems(String memberUuid);

    Optional<Cart> findByCartUuid(String cartUuid);

    void deleteByCartUuid(String cartUuid);

    List<Cart> findByMemberUuid(String memberUuid);
}
