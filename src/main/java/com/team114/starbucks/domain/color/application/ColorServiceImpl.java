package com.team114.starbucks.domain.color.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.color.dto.in.ColorRequestDto;
import com.team114.starbucks.domain.color.dto.out.ColorResponseDto;
import com.team114.starbucks.domain.color.entity.Color;
import com.team114.starbucks.domain.color.infrastructure.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;

    // Color 생성
    @Transactional
    @Override
    public ColorResponseDto saveColor(ColorRequestDto colorRequestDto) {
        try {
            Color newColor = colorRequestDto.toEntity();

            Color savedColor = colorRepository.save(newColor);

            return ColorResponseDto.from(savedColor);

        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_SAVE);
        }
    }

    // Color 전체 조회
    @Override
    public List<ColorResponseDto> findAllColors() {
        return colorRepository.findAll().stream().map(ColorResponseDto::from).toList();
    }

    @Override
    public ColorResponseDto findByColorId(Long colorId) {

        Color color = colorRepository.findByColorId(colorId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND) );

        return ColorResponseDto.from(color);
    }

    @Transactional
    @Override
    public ColorResponseDto updateColor(Long colorId, ColorRequestDto colorRequestDto) {

        Color color = colorRepository.findByColorId(colorId).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        Color updateColor = Color.builder()
                .colorId(color.getColorId())
                .colorName(colorRequestDto.getColorName() == null ? color.getColorName() : colorRequestDto.getColorName())
                .build();

        colorRepository.save(updateColor);

        return ColorResponseDto.from(color);
    }

    @Transactional
    @Override
    public Void deleteColor(Long colorId){

        colorRepository.deleteByColorId(colorId).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        return null;
    }
}
