package com.team114.starbucks.domain.size.dto.out;

import com.team114.starbucks.domain.size.entity.Size;
import com.team114.starbucks.domain.size.vo.out.SizeResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SizeResponseDto {

    private Long sizeId;
    private String sizeName;
    private String sizeCode;
    private String sizeDescription;

    @Builder
    public SizeResponseDto(
            Long sizeId,
            String sizeName,
            String sizeCode,
            String sizeDescription
    ) {
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.sizeCode = sizeCode;
        this.sizeDescription = sizeDescription;
    }

    public static SizeResponseDto from(Size size) {
        return SizeResponseDto.builder()
                .sizeId(size.getSizeId())
                .sizeName(size.getSizeName())
                .sizeCode(size.getSizeCode())
                .sizeDescription(size.getSizeDescription())
                .build();
    }

    public SizeResponseVo toVo() {
        return SizeResponseVo.builder()
                .sizeId(sizeId)
                .sizeName(sizeName)
                .sizeCode(sizeCode)
                .sizeDescription(sizeDescription)
                .build();
    }
}
