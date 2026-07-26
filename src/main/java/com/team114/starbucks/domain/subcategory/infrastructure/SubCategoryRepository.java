package com.team114.starbucks.domain.subcategory.infrastructure;

import com.team114.starbucks.domain.subcategory.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    Optional<SubCategory> findSubCategoryBySubCategoryUuid(String subCategoryUuid);

    Optional<SubCategory> findBySubCategoryName(String subCategoryName);

}