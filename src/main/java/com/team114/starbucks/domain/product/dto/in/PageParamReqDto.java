package com.team114.starbucks.domain.product.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PageParamReqDto {

    private String mainCategoryUuid;

    @Builder
    public PageParamReqDto(String mainCategoryUuid) {
        this.mainCategoryUuid = mainCategoryUuid;
    }

    public static PageParamReqDto from(String mainCategoryUuid) {
        return PageParamReqDto.builder()
                .mainCategoryUuid(mainCategoryUuid)
                .build();
    }
}
