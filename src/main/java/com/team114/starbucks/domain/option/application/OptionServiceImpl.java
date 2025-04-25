package com.team114.starbucks.domain.option.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.color.entity.Color;
import com.team114.starbucks.domain.color.infrastructure.ColorRepository;
import com.team114.starbucks.domain.option.dto.in.CreateOptionReqDto;
import com.team114.starbucks.domain.option.dto.in.UpdateOptionReqDto;
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

    @Transactional
    @Override
    public void saveOption(CreateOptionReqDto createOptionReqDto) {
            Color color = colorRepository.findByColorId(createOptionReqDto.getColorId())
                    .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));
            Size size = sizeRepository.findBySizeId(createOptionReqDto.getSizeId())
                    .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

            OptionResponseDto.from(optionRepository.save(createOptionReqDto.toEntity(color, size)));
    }

    @Override
    public List<OptionResponseDto> findAllOptions() {

        return optionRepository.findAll().stream().map(OptionResponseDto::from).toList();
    }

    @Override
    public OptionResponseDto findOptionById(Long optionId) {
        Option option = optionRepository.findByOptionId(optionId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        return OptionResponseDto.from(option);
    }

    @Transactional
    @Override
    public void updateOption(UpdateOptionReqDto updateOptionReqDto) {
        Option option = optionRepository.findByOptionId(updateOptionReqDto.getOptionId()).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        optionRepository.save(updateOptionReqDto.toEntity(option));
    }

    @Transactional
    @Override
    public void deleteOption(Long optionId) {
        optionRepository.deleteByOptionId(optionId).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );
    }

    @Override
    public Option findAnyOptionByProductUuid(String productUuid) {
        return optionRepository.findAnyOptionByProductUuid(productUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));
    }

}