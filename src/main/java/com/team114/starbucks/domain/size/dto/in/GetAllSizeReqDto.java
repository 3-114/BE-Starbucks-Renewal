package com.team114.starbucks.domain.size.dto.in;

import com.team114.starbucks.domain.size.entity.Size;
import com.team114.starbucks.domain.size.vo.in.GetAllSizeReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllSizeReqDto {
    private String sizeName;
    private String sizeCode;
    private String sizeDescription;

    @Builder
    public GetAllSizeReqDto(
            String sizeName,
            String sizeCode,
            String sizeDescription
    ) {
        this.sizeName = sizeName;
        this.sizeCode = sizeCode;
        this.sizeDescription = sizeDescription;
    }

    public static GetAllSizeReqDto from(
            GetAllSizeReqVo getAllSizeReqVo
    ) {
        return GetAllSizeReqDto.builder()
                .sizeName(getAllSizeReqVo.getSizeName())
                .sizeCode(getAllSizeReqVo.getSizeCode())
                .sizeDescription(getAllSizeReqVo.getSizeDescription())
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