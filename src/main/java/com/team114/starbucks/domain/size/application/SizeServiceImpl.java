package com.team114.starbucks.domain.size.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.size.dto.in.GetAllSizeReqDto;
import com.team114.starbucks.domain.size.dto.out.GetAllSizeResDto;
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
    public GetAllSizeResDto saveSize(GetAllSizeReqDto getAllSizeReqDto) {
        try {
            Size newSize = getAllSizeReqDto.toEntity();
            Size savedSize = sizeRepository.save(newSize);

            return GetAllSizeResDto.from(savedSize);
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_SAVE);
        }
    }

    @Override
    public List<GetAllSizeResDto> findAllSizes() {

        return sizeRepository.findAll().stream().map(GetAllSizeResDto::from).toList();
    }

    @Override
    public GetAllSizeResDto findBySizeId(Long sizeId) {
        Size size = sizeRepository.findBySizeId(sizeId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        return GetAllSizeResDto.from(size);
    }

    @Transactional
    @Override
    public GetAllSizeResDto updateSize(Long sizeId, GetAllSizeReqDto getAllSizeReqDto) {
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

        return GetAllSizeResDto.from(updatedSize);
    }

    @Transactional
    @Override
    public void deleteSize(Long sizeId) {
        sizeRepository.deleteBySizeId(sizeId).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );
    }

}