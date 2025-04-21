package com.team114.starbucks.domain.productcategory.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@NoArgsConstructor
public class PageParamDto {

    private String mainCategoryUuid;
    private int page;
    private int size;

    @Builder
    public PageParamDto(String mainCategoryUuid, int page, int size) {
        this.mainCategoryUuid = mainCategoryUuid;
        this.page = page;
        this.size = size;
    }

    public static PageParamDto of(String mainCategoryUuid, int page, int size) {
        return PageParamDto.builder()
                .mainCategoryUuid(mainCategoryUuid)
                .page(page)
                .size(size)
                .build();
    }

    public Pageable toEntity() {
        return PageRequest.of(page - 1, size);
    }
}
