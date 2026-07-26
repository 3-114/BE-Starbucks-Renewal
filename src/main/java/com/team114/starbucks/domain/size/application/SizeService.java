package com.team114.starbucks.domain.size.application;

import com.team114.starbucks.domain.size.dto.in.GetAllSizeReqDto;
import com.team114.starbucks.domain.size.dto.out.GetAllSizeResDto;

import java.util.List;

public interface SizeService {

    GetAllSizeResDto saveSize(GetAllSizeReqDto getAllSizeReqDto);

    List<GetAllSizeResDto> findAllSizes();

    GetAllSizeResDto findBySizeId(Long sizeId);

    GetAllSizeResDto updateSize(Long sizeId, GetAllSizeReqDto getAllSizeReqDto);

    void deleteSize(Long sizeId);

}
