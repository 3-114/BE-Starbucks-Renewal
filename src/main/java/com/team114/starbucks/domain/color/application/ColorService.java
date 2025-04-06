package com.team114.starbucks.domain.color.application;

import com.team114.starbucks.domain.color.dto.in.ColorRequestDto;
import com.team114.starbucks.domain.color.dto.out.ColorResponseDto;

import java.util.List;

public interface ColorService {

    ColorResponseDto saveColor(ColorRequestDto colorRequestDto);

    List<ColorResponseDto> findAllColors();

    ColorResponseDto findByColorId(Long colorId);

    ColorResponseDto updateColor(Long colorId, ColorRequestDto colorRequestDto);

    Void deleteColor(Long colorId);
}
