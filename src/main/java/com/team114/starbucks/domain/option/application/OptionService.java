package com.team114.starbucks.domain.option.application;

import com.team114.starbucks.domain.option.dto.out.OptionResponseDto;

import java.util.List;

public interface OptionService {

    // 상품 UUID 기반 옵션 목록 조회
    List<OptionResponseDto> findOptionsByProductUuid(String productUuid);
    List<OptionResponseDto> findAllOptions();
}