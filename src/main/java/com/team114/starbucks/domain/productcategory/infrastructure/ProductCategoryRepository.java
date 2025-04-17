package com.team114.starbucks.domain.productcategory.infrastructure;

import com.team114.starbucks.domain.productcategory.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    List<ProductCategory> findAllProductUuidByEventUuid(String eventUuid);

}
