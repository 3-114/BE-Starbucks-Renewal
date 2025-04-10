package com.team114.starbucks.domain.subcategory.infrastructure;

import com.team114.starbucks.domain.subcategory.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
}
