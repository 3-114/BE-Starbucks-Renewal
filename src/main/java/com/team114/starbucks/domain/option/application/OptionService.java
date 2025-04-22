package com.team114.starbucks.domain.option.application;

import com.team114.starbucks.domain.option.dto.in.OptionCreateRequestDto;
import com.team114.starbucks.domain.option.dto.in.OptionUpdateRequestDto;
import com.team114.starbucks.domain.option.dto.out.OptionResponseDto;
import com.team114.starbucks.domain.option.entity.Option;

import java.util.List;

public interface OptionService {

    void saveOption(OptionCreateRequestDto optionCreateRequestDto);

    List<OptionResponseDto> findAllOptions();

    OptionResponseDto findOptionById(Long optionId);

    void updateOption(OptionUpdateRequestDto optionUpdateRequestDto);

    void deleteOption(Long optionId);

    Option findAnyOptionByProductUuid(String productUuid);
}