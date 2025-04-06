package com.team114.starbucks.domain.size.application;

import com.team114.starbucks.domain.size.dto.in.SizeRequestDto;
import com.team114.starbucks.domain.size.dto.out.SizeResponseDto;

import java.util.List;

public interface SizeService {

    SizeResponseDto saveSize(SizeRequestDto sizeRequestDto);

    List<SizeResponseDto> findAllSizes();

    SizeResponseDto findBySizeId(Long sizeId);

    SizeResponseDto updateSize(Long sizeId, SizeRequestDto sizeRequestDto);

    Void deleteSize(Long sizeId);

}
