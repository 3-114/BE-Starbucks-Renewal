package com.team114.starbucks.domain.option.application;

import com.team114.starbucks.domain.option.dto.in.CreateOptionReqDto;
import com.team114.starbucks.domain.option.dto.in.UpdateOptionReqDto;
import com.team114.starbucks.domain.option.dto.out.OptionResponseDto;
import com.team114.starbucks.domain.option.entity.Option;

import java.util.List;

public interface OptionService {

    void saveOption(CreateOptionReqDto createOptionReqDto);

    List<OptionResponseDto> findAllOptions();

    OptionResponseDto findOptionById(Long optionId);

    void updateOption(UpdateOptionReqDto updateOptionReqDto);

    void deleteOption(Long optionId);

    Option findAnyOptionByProductUuid(String productUuid);

}