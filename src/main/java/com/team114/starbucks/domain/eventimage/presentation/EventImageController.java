package com.team114.starbucks.domain.eventimage.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.eventimage.application.EventImageService;
import com.team114.starbucks.domain.eventimage.dto.in.CreateEventImageReqDto;
import com.team114.starbucks.domain.eventimage.dto.out.GetAllEventUrlAndIndexResDto;
import com.team114.starbucks.domain.eventimage.vo.in.CreateEventImageReqVo;
import com.team114.starbucks.domain.eventimage.vo.out.GetAllEventUrlAndIndexResVo;
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

    /**
     * 1. 기획전 이미지 전체 조회
     * 2. 기획전 이미지 생성
     */

    /**
     * 1. 기획전 이미지 전체 조회
     *
     * @param eventUuid 기획전 UUID
     * @return {@link BaseResponseEntity} 기획전 이미지 전체 조회 결과
     */
    @Operation(summary = "기획전 상세내역 이미지 조회", tags = {"event"})
    @GetMapping("/{eventUuid}")
    public BaseResponseEntity<List<GetAllEventUrlAndIndexResVo>> getEventUrlAndIndex(
            @PathVariable String eventUuid
    ) {
        List<GetAllEventUrlAndIndexResDto> dtoList = eventImageService.getEventUrlAndIndex(eventUuid);
        List<GetAllEventUrlAndIndexResVo> voList = new ArrayList<>();

        for (GetAllEventUrlAndIndexResDto getAllEventUrlAndIndexResDto : dtoList) {
            voList.add(getAllEventUrlAndIndexResDto.toVo());
        }

        return new BaseResponseEntity<>("기획전 URL 조회에 성공하였습니다. ", voList);
    }

    /**
     * 2. 기획전 이미지 생성
     *
     * @param createEventImageReqVo 기획전 이미지 데이터
     * @return {@link BaseResponseEntity} 기획전 이미지 생성 결과
     */
    @Operation(summary = "기획전 상세내역 이미지 생성", tags = {"event"})
    @PostMapping
    public BaseResponseEntity<Void> createEventImage(
            @RequestBody CreateEventImageReqVo createEventImageReqVo
    ) {
        eventImageService.createEventImage(CreateEventImageReqDto.from(createEventImageReqVo));

        return new BaseResponseEntity<>("이벤트 이미지 생성에 성공했습니다. ", null);
    }

}
