package com.team114.starbucks.domain.option.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.option.dto.out.OptionResponseDto;
import com.team114.starbucks.domain.option.entity.Option;
import com.team114.starbucks.domain.option.infrastructure.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;

    @Override
    public List<OptionResponseDto> findOptionsByProductUuid(String productUuid) {
        try {
            List<Option> optionList = optionRepository.findByProductUuid(productUuid);
            return optionList.stream().map(OptionResponseDto::fromEntity).toList();
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.NO_EXIST_OPTION);
        }
    }

    @Override
    public List<OptionResponseDto> findAllOptions() {
        try {
            List<Option> optionList = optionRepository.findAll();
            return optionList.stream().map(OptionResponseDto::fromEntity).toList();
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.NO_EXIST_OPTION);
        }
    }
}