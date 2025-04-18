package com.team114.starbucks.domain.eventimage.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetEventUrlAndIndexResVo {

    private String eventUrl;
    private int eventUrlIndex;

    @Builder
    public GetEventUrlAndIndexResVo(String eventUrl, int eventUrlIndex) {
        this.eventUrl = eventUrl;
        this.eventUrlIndex = eventUrlIndex;
    }
}
