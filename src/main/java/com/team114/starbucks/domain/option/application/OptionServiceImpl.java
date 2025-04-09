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

    @Transactional
    @Override
    public OptionResponseDto saveOption(OptionCreateRequestDto optionCreateRequestDto) {
        try {
            // color repository 에서 colorid로 color 객체 조회
            Color color = colorRepository.findByColorId(optionCreateRequestDto.getColorId()).orElse(null);
            // size repository 에서 sizeid로 size 객체 조회
            Size size = sizeRepository.findBySizeId(optionCreateRequestDto.getSizeId()).orElse(null);

            Option newOption = optionCreateRequestDto.toEntity(color, size);

            Option savedOption = optionRepository.save(newOption);

            return OptionResponseDto.from(savedOption);

        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_SAVE);
        }
    }

    // 옵션 전체 조회
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

    // 옵션 정보 변경
    @Transactional
    @Override
    public OptionResponseDto updateOption(Long optionId, OptionUpdateRequestDto optionUpdateRequestDto) {
        // option객체 조회
        // optionrepo에서 findByOptionId(updateDto.getOptionId)
        Option option = optionRepository.findByOptionId(optionId).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        // color repository 에서 colorid로 color 객체 조회
        Color color = colorRepository.findByColorId(optionUpdateRequestDto.getColorId()).orElse(null);
        // size repository 에서 sizeid로 size 객체 조회
        Size size = sizeRepository.findBySizeId(optionUpdateRequestDto.getSizeId()).orElse(null);

        Option newOption = optionUpdateRequestDto.toEntity(optionId ,color, size);

        Option updatedOption = Option.builder()
                .optionId(option.getOptionId())
                .productUuid(optionUpdateRequestDto.getProductUuid())
                .color(option.getColor())
                .size(option.getSize())
                .stock(optionUpdateRequestDto.getStock())
                .optionPrice(optionUpdateRequestDto.getOptionPrice())
                .discountRate(optionUpdateRequestDto.getDiscountRate())
                .build();

        Option savedOption = optionRepository.save(updatedOption);

        return OptionResponseDto.from(savedOption);
    }

    // 옵션 삭제
    @Transactional
    @Override
    public Void deleteOption(Long optionId) {
        optionRepository.deleteByOptionId(optionId).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        return null;
    }
}