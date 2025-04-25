package com.team114.starbucks.domain.option.infrastructure;

import com.team114.starbucks.domain.option.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OptionRepository extends JpaRepository<Option, Integer> {

    Optional<Option> findByOptionId(Long optionId);

    Optional<Option> deleteByOptionId(Long optionId);

    List<Option> findByProductUuid(String productUuid);

    Optional<Option> findAnyOptionByProductUuid(String productUuid);

}