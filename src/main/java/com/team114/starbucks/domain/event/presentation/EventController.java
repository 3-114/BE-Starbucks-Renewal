package com.team114.starbucks.domain.event.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.event.application.EventServiceimpl;
import com.team114.starbucks.domain.event.dto.in.CreateEventReqDto;
import com.team114.starbucks.domain.event.dto.in.UpdateEventReqDto;
import com.team114.starbucks.domain.event.dto.out.EventResponseDto;
import com.team114.starbucks.domain.event.dto.out.GetOneEventResDto;
import com.team114.starbucks.domain.event.vo.in.CreateEventReqVo;
import com.team114.starbucks.domain.event.vo.in.UpdateEventReqVo;
import com.team114.starbucks.domain.event.vo.out.CreateEventResVo;
import com.team114.starbucks.domain.event.vo.out.EventResponseVo;
import com.team114.starbucks.domain.event.vo.out.GetOneEventResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/event")
public class EventController {

    private final EventServiceimpl eventService;

    /*
     * 1. 기획전 생성
     * 2. 기획전 전체 조회
     * 3. 기획전 단건 조회
     * 4. 기획전 수정
     * 5. 기획전 삭제
     * */

    // 1. 기획전 생성
    @PostMapping
    public BaseResponseEntity<CreateEventResVo> createEvent(
            @RequestBody CreateEventReqVo createEventReqVo
    ) {

        return new BaseResponseEntity<>(
                "기획전 생성에 성공하였습니다.",
                eventService.saveEvent(CreateEventReqDto.from(createEventReqVo)).toVo());
    }

    // 2. 기획전 전체 조회
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


    // 3. 기획전 단건 조회
    @GetMapping("/{eventUuid}")
    public GetOneEventResVo getEvent(
            @PathVariable String eventUuid
    ) {
        GetOneEventResDto getOneEventResDto = eventService.findEventByUuid(eventUuid);
        GetOneEventResVo getOneEventResVo = getOneEventResDto.toVo();

        return getOneEventResVo;
    }


    // 4. 기획전 수정
    @PutMapping("/{eventUuid}")
    public BaseResponseEntity<Void> updateEvent(
            @PathVariable String eventUuid,
            @RequestBody UpdateEventReqVo updateEventReqVo
    ) {
        eventService.updateEvent(eventUuid, UpdateEventReqDto.from(updateEventReqVo));
        return new BaseResponseEntity<>(
                "기획전 삭제에 성공하였습니다. ",
                null
        );
    }

    // 5. 기획전 삭제
    @DeleteMapping("/{eventUuid}")
    public BaseResponseEntity<Void> deleteEvent(
            @PathVariable String eventUuid
    ) {
        eventService.deleteEvent(eventUuid);
        return new BaseResponseEntity<>("기획전이 삭제되었습니다. ", null);
    }
}
