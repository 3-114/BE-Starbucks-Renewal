package com.team114.starbucks.domain.event.presentation;

import com.team114.starbucks.domain.event.application.EventService;
import com.team114.starbucks.domain.event.dto.EventResponseDto;
import com.team114.starbucks.domain.event.vo.EventResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/test")
    public List<EventResponseVo> getAllEventName() {

        List<EventResponseDto> dtoList = eventService.getAllEventName();

        List<EventResponseVo> voList = new ArrayList<>();

        for (EventResponseDto eventResponseDto : dtoList) {
            EventResponseVo eventResponseVo = eventResponseDto.toVo();
            voList.add(eventResponseVo);
        }

        return voList;



    }
}
