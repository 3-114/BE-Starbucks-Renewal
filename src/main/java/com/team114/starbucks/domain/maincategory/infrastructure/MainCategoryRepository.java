package com.team114.starbucks.domain.maincategory.infrastructure;

import com.team114.starbucks.domain.maincategory.entity.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory, Long> {
}
