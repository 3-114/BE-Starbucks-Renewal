package com.team114.starbucks.domain.size.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.size.dto.in.SizeRequestDto;
import com.team114.starbucks.domain.size.dto.out.SizeResponseDto;
import com.team114.starbucks.domain.size.entity.Size;
import com.team114.starbucks.domain.size.infrastructure.SizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SizeServiceImpl implements SizeService{

    private final SizeRepository sizeRepository;

    @Transactional
    @Override
    public SizeResponseDto saveSize(SizeRequestDto sizeRequestDto) {
        try {
            Size newSize = sizeRequestDto.toEntity();

            Size savedSize = sizeRepository.save(newSize);

            return SizeResponseDto.from(savedSize);
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_SAVE);
        }
    }

    @Override
    public List<SizeResponseDto> findAllSizes() {
        return sizeRepository.findAll().stream().map(SizeResponseDto::from).toList();
    }

    @Override
    public SizeResponseDto findBySizeId(Long sizeId) {
        Size size = sizeRepository.findBySizeId(sizeId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        return SizeResponseDto.from(size);
    }

    @Transactional
    @Override
    public SizeResponseDto updateSize(Long sizeId, SizeRequestDto sizeRequestDto) {
        Size size = sizeRepository.findBySizeId(sizeId).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        Size updatedSize = Size.builder()
                .sizeId(size.getSizeId())
                .sizeName(size.getSizeName())
                .sizeCode(size.getSizeCode())
                .sizeDescription(size.getSizeDescription())
                .build();

        sizeRepository.save(updatedSize);

        return SizeResponseDto.from(updatedSize);
    }

    @Transactional
    @Override
    public Void deleteSize(Long sizeId) {
        sizeRepository.deleteBySizeId(sizeId).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        return null;
    }
}
