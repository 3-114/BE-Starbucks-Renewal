package com.team114.starbucks.domain.option.application;

import com.team114.starbucks.domain.option.dto.in.OptionCreateRequestDto;
import com.team114.starbucks.domain.option.dto.in.OptionUpdateRequestDto;
import com.team114.starbucks.domain.option.dto.out.OptionResponseDto;

import java.util.List;

public interface OptionService {

    OptionResponseDto saveOption(OptionCreateRequestDto optionCreateRequestDto);

    List<OptionResponseDto> findAllOptions();

    OptionResponseDto findOptionById(Long optionId);

    OptionResponseDto updateOption(Long optionId, OptionUpdateRequestDto optionUpdateRequestDto);

    Void deleteOption(Long optionId);
}