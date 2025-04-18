package com.team114.starbucks.domain.eventimage.presentation;

import com.team114.starbucks.domain.eventimage.application.EventImageService;
import com.team114.starbucks.domain.eventimage.dto.out.GetEventUrlAndIndexResDto;
import com.team114.starbucks.domain.eventimage.vo.out.GetEventUrlAndIndexResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/event-image")
public class EventImageController {

    private final EventImageService eventImageService;



    @GetMapping("/{eventUuid}")
    public List<GetEventUrlAndIndexResVo> getEventUrlAndIndex(
            @PathVariable String eventUuid
    ) {
        List<GetEventUrlAndIndexResDto> dtoList = eventImageService.getEventUrlAndIndex(eventUuid);
        List<GetEventUrlAndIndexResVo> voList = new ArrayList<>();

        for (GetEventUrlAndIndexResDto getEventUrlAndIndexResDto : dtoList) {
            voList.add(getEventUrlAndIndexResDto.toVo());
        }

        return voList;

    }

}
