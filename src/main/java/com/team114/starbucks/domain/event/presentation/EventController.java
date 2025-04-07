package com.team114.starbucks.domain.event.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.event.application.EventServiceimpl;
import com.team114.starbucks.domain.event.dto.EventResponseDto;
import com.team114.starbucks.domain.event.dto.in.CreateEventReqDto;
import com.team114.starbucks.domain.event.vo.EventResponseVo;
import com.team114.starbucks.domain.event.vo.in.CreateEventReqVo;
import com.team114.starbucks.domain.event.vo.out.CreateEventResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/event")
public class EventController {

    private final EventServiceimpl eventService;

    // 기획전 전체 조회
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

    // 기획전 생성
    @PostMapping
    public BaseResponseEntity<CreateEventResVo> createEvent(
            @RequestBody CreateEventReqVo createEventReqVo
    ) {
        return new BaseResponseEntity<>(
                "기획전 생성에 성공하였습니다.",
                eventService.saveEvent(CreateEventReqDto.from(createEventReqVo)).toVo());
    }
}
