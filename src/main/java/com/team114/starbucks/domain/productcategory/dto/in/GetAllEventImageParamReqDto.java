package com.team114.starbucks.domain.productcategory.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@NoArgsConstructor
public class GetAllEventImageParamReqDto {

    private String eventUuid;
    private int page;
    private int size;

    @Builder
    public GetAllEventImageParamReqDto(String eventUuid, int page, int size) {
        this.eventUuid = eventUuid;
        this.page = page;
        this.size = size;
    }


    public static GetAllEventImageParamReqDto of(String eventUuid, int page, int size) {
        return GetAllEventImageParamReqDto.builder()
                .eventUuid(eventUuid)
                .page(page)
                .size(size)
                .build();
    }

    public Pageable toPageable() {
        return PageRequest.of(page - 1, size);
    }
}
