package com.team114.starbucks.domain.eventimage.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetAllEventUrlAndIndexResVo {

    private String eventUrl;
    private int eventUrlIndex;

    @Builder
    public GetAllEventUrlAndIndexResVo(String eventUrl, int eventUrlIndex) {
        this.eventUrl = eventUrl;
        this.eventUrlIndex = eventUrlIndex;
    }

}