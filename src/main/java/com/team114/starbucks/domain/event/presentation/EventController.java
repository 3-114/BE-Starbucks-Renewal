package com.team114.starbucks.domain.event.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.event.application.EventServiceimpl;
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
@RequestMapping("/api/v1/event")
public class EventController {

    private final EventServiceimpl eventService;

    @GetMapping("/nav")
    public BaseResponseEntity<List<EventResponseVo>> getAllEventName() {

        List<EventResponseDto> dtoList = eventService.findAllActiveEvents();

        List<EventResponseVo> voList = new ArrayList<>();

        for (EventResponseDto eventResponseDto : dtoList) {
            EventResponseVo eventResponseVo = eventResponseDto.toVo();
            voList.add(eventResponseVo);
        }

        return new BaseResponseEntity<>("기획전 조회에 성공하였습니다.", voList);


    }
}
