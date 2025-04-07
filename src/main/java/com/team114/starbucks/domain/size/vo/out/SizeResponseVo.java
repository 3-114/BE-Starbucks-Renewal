package com.team114.starbucks.domain.size.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SizeResponseVo {

    private Long sizeId;
    private String sizeName;
    private String sizeCode;
    private String sizeDescription;

    @Builder
    public SizeResponseVo(
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
}
