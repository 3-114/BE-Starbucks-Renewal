package com.team114.starbucks.domain.option.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.color.entity.Color;
import com.team114.starbucks.domain.color.infrastructure.ColorRepository;
import com.team114.starbucks.domain.option.dto.in.OptionCreateRequestDto;
import com.team114.starbucks.domain.option.dto.in.OptionUpdateRequestDto;
import com.team114.starbucks.domain.option.dto.out.OptionResponseDto;
import com.team114.starbucks.domain.option.entity.Option;
import com.team114.starbucks.domain.option.infrastructure.OptionRepository;
import com.team114.starbucks.domain.size.entity.Size;
import com.team114.starbucks.domain.size.infrastructure.SizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;
    private final SizeRepository sizeRepository;
    private final ColorRepository colorRepository;

    // 옵션 생성
    @Transactional
    @Override
    public void saveOption(OptionCreateRequestDto optionCreateRequestDto) {

            Color color = colorRepository.findByColorId(optionCreateRequestDto.getColorId())
                    .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));
            Size size = sizeRepository.findBySizeId(optionCreateRequestDto.getSizeId())
                    .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

            OptionResponseDto.from(optionRepository.save(optionCreateRequestDto.toEntity(color, size)));
    }

    // 옵션 전체 조회
    @Override
    public List<OptionResponseDto> findAllOptions() {

        return optionRepository.findAll().stream().map(OptionResponseDto::from).toList();
    }

    // 옵션 단건 조회
    @Override
    public OptionResponseDto findOptionById(Long optionId) {

        Option option = optionRepository.findByOptionId(optionId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        return OptionResponseDto.from(option);
    }

    // 옵션 정보 변경
    @Transactional
    @Override
    public void updateOption(OptionUpdateRequestDto optionUpdateRequestDto) {

        Option option = optionRepository.findByOptionId(optionUpdateRequestDto.getOptionId()).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        optionRepository.save(optionUpdateRequestDto.toEntity(option));

    }

    // 옵션 삭제
    @Transactional
    @Override
    public void deleteOption(Long optionId) {
        optionRepository.deleteByOptionId(optionId).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );
    }
}