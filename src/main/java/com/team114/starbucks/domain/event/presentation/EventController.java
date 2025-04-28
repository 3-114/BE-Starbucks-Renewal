package com.team114.starbucks.domain.event.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.event.application.EventServiceimpl;
import com.team114.starbucks.domain.event.dto.in.CreateEventReqDto;
import com.team114.starbucks.domain.event.dto.in.UpdateEventReqDto;
import com.team114.starbucks.domain.event.dto.out.GetAllEventResDto;
import com.team114.starbucks.domain.event.dto.out.GetEventResDto;
import com.team114.starbucks.domain.event.vo.in.CreateEventReqVo;
import com.team114.starbucks.domain.event.vo.in.UpdateEventReqVo;
import com.team114.starbucks.domain.event.vo.out.CreateEventResVo;
import com.team114.starbucks.domain.event.vo.out.GetAllEventResVo;
import com.team114.starbucks.domain.event.vo.out.GetEventResVo;
import io.swagger.v3.oas.annotations.Operation;
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

    /**
     * 1. 기획전 생성
     *
     * @param createEventReqVo 기획전 데이터
     * @return {@link BaseResponseEntity} 기획전 생성 결과
     */
    @Operation(summary = "기획전 생성", tags = {"event"})
    @PostMapping
    public BaseResponseEntity<CreateEventResVo> createEvent(
            @RequestBody CreateEventReqVo createEventReqVo
    ) {
        return new BaseResponseEntity<>("기획전 생성에 성공하였습니다.",
                eventService.saveEvent(CreateEventReqDto.from(createEventReqVo)).toVo());
    }

    /**
     * 2. 기획전 전체 조회
     *
     * @return {@link BaseResponseEntity} 기획전 전체 조회 결과
     */
    @Operation(summary = "기획전 전체 조회", tags = {"event"})
    @GetMapping("/nav")
    public BaseResponseEntity<List<GetAllEventResVo>> getAllEventName() {

        List<GetAllEventResDto> dtoList = eventService.findAllActiveEvents();
        List<GetAllEventResVo> voList = new ArrayList<>();

        for (GetAllEventResDto getAllEventResDto : dtoList) {
            GetAllEventResVo getAllEventResVo = getAllEventResDto.toVo();
            voList.add(getAllEventResVo);
        }
        return new BaseResponseEntity<>("기획전 조회에 성공하였습니다.", voList);
    }

    /**
     * 3. 기획전 단건 조회
     *
     * @param eventUuid 기획전 UUID
     * @return {@link BaseResponseEntity} 기획전 단건 조회 결과
     */
    @Operation(summary = "기획전 단건 조회", tags = {"event"})
    @GetMapping("/{eventUuid}")
    public BaseResponseEntity<GetEventResVo> getEvent(
            @PathVariable String eventUuid
    ) {
        GetEventResDto getEventResDto = eventService.findEventByUuid(eventUuid);
        return new BaseResponseEntity<>("기획전 단건 조회에 성공하였습니다. ", getEventResDto.toVo());
    }


    /**
     * 4. 기획전 수정
     *
     * @param eventUuid        기획전 UUID
     * @param updateEventReqVo 기획전 수정 데이터
     * @return {@link BaseResponseEntity} 기획전 수정 결과
     */
    @Operation(summary = "기획전 수정", tags = {"event"})
    @PutMapping("/{eventUuid}")
    public BaseResponseEntity<Void> updateEvent(
            @PathVariable String eventUuid,
            @RequestBody UpdateEventReqVo updateEventReqVo
    ) {
        eventService.updateEvent(eventUuid, UpdateEventReqDto.from(updateEventReqVo));
        return new BaseResponseEntity<>("기획전 수정에 성공하였습니다. ", null);
    }

    /**
     * 5. 기획전 삭제
     *
     * @param eventUuid 기획전 UUID
     * @return {@link BaseResponseEntity} 기획전 수정 결과
     */
    @Operation(summary = "기획전 삭제", tags = {"event"})
    @DeleteMapping("/{eventUuid}")
    public BaseResponseEntity<Void> deleteEvent(
            @PathVariable String eventUuid
    ) {
        eventService.deleteEvent(eventUuid);
        return new BaseResponseEntity<>("기획전이 삭제되었습니다. ", null);
    }
}
