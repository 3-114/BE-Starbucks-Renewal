package com.team114.starbucks.domain.eventimage.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.eventimage.application.EventImageService;
import com.team114.starbucks.domain.eventimage.dto.in.CreateEventImageReqDto;
import com.team114.starbucks.domain.eventimage.dto.out.GetEventUrlAndIndexResDto;
import com.team114.starbucks.domain.eventimage.vo.in.CreateEventImageReqVo;
import com.team114.starbucks.domain.eventimage.vo.out.GetEventUrlAndIndexResVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/event-image")
public class EventImageController {

    private final EventImageService eventImageService;


    // [GET] eventUuid -> eventUrl, eventUrlIndex 조회
    @Operation(summary = "기획전 상세내역 이미지 조회", tags = {"event"})
    @GetMapping("/{eventUuid}")
    public BaseResponseEntity<List<GetEventUrlAndIndexResVo>> getEventUrlAndIndex(
            @PathVariable String eventUuid
    ) {
        List<GetEventUrlAndIndexResDto> dtoList = eventImageService.getEventUrlAndIndex(eventUuid);
        List<GetEventUrlAndIndexResVo> voList = new ArrayList<>();

        for (GetEventUrlAndIndexResDto getEventUrlAndIndexResDto : dtoList) {
            voList.add(getEventUrlAndIndexResDto.toVo());
        }

        return new BaseResponseEntity<>("기획전 URL 조회에 성공하였습니다. ", voList);
    }

    // [POST]
    @Operation(summary = "기획전 상세내역 생성", tags = {"event"})
    @PostMapping
    public BaseResponseEntity<Void> createEventImage(
            @RequestBody CreateEventImageReqVo createEventImageReqVo
    ) {
        eventImageService.createEventImage(CreateEventImageReqDto.from(createEventImageReqVo));

        return new BaseResponseEntity<>("이벤트 이미지 생성에 성공했습니다. ", null);
    }

}
