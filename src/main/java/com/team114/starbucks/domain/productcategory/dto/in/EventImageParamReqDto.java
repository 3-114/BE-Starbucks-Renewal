package com.team114.starbucks.domain.productcategory.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@NoArgsConstructor
public class EventImageParamReqDto {

    private String eventUuid;
    private int page;
    private int size;

    @Builder
    public EventImageParamReqDto(String eventUuid, int page, int size) {
        this.eventUuid = eventUuid;
        this.page = page;
        this.size = size;
    }


    public static EventImageParamReqDto of(String eventUuid, int page, int size) {
        return EventImageParamReqDto.builder()
                .eventUuid(eventUuid)
                .page(page)
                .size(size)
                .build();
    }

    public Pageable toPageable() {
        return PageRequest.of(page - 1, size);
    }
}
