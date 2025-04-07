package com.team114.starbucks.domain.size.dto.in;

import com.team114.starbucks.domain.size.entity.Size;
import com.team114.starbucks.domain.size.vo.in.SizeRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SizeRequestDto {
    private String sizeName;
    private String sizeCode;
    private String sizeDescription;

    @Builder
    public SizeRequestDto(
            String sizeName,
            String sizeCode,
            String sizeDescription
    ) {
        this.sizeName = sizeName;
        this.sizeCode = sizeCode;
        this.sizeDescription = sizeDescription;
    }

    public static SizeRequestDto from(
            SizeRequestVo sizeRequestVo
    ) {
        return SizeRequestDto.builder()
                .sizeName(sizeRequestVo.getSizeName())
                .sizeCode(sizeRequestVo.getSizeCode())
                .sizeDescription(sizeRequestVo.getSizeDescription())
                .build();
    }

    public Size toEntity() {
        return Size.builder()
                .sizeName(sizeName)
                .sizeCode(sizeCode)
                .sizeDescription(sizeDescription)
                .build();
    }
}
