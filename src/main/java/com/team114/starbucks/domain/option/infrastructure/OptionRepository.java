package com.team114.starbucks.domain.option.infrastructure;

import com.team114.starbucks.domain.option.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Integer> {

    // 상품 UUID 기반 옵션 목록 조회
    List<Option> findByProductUuid(String productUuid);
}