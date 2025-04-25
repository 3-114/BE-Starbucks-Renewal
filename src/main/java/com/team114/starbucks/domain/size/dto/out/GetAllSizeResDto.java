package com.team114.starbucks.domain.size.dto.out;

import com.team114.starbucks.domain.size.entity.Size;
import com.team114.starbucks.domain.size.vo.out.GetAllSizeResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllSizeResDto {

    private Long sizeId;
    private String sizeName;
    private String sizeCode;
    private String sizeDescription;

    @Builder
    public GetAllSizeResDto(
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

    public static GetAllSizeResDto from(Size size) {
        return GetAllSizeResDto.builder()
                .sizeId(size.getSizeId())
                .sizeName(size.getSizeName())
                .sizeCode(size.getSizeCode())
                .sizeDescription(size.getSizeDescription())
                .build();
    }

    public GetAllSizeResVo toVo() {
        return GetAllSizeResVo.builder()
                .sizeId(sizeId)
                .sizeName(sizeName)
                .sizeCode(sizeCode)
                .sizeDescription(sizeDescription)
                .build();
    }

}