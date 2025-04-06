package com.team114.starbucks.domain.color.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.color.application.ColorService;
import com.team114.starbucks.domain.color.dto.in.ColorRequestDto;
import com.team114.starbucks.domain.color.dto.out.ColorResponseDto;
import com.team114.starbucks.domain.color.vo.in.ColorRequestVo;
import com.team114.starbucks.domain.color.vo.out.ColorResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/color")
public class ColorController {

    private final ColorService colorService;

    // 1. Color 생성
    @PostMapping
    public BaseResponseEntity<ColorResponseVo> createColor(
            @RequestBody ColorRequestVo colorRequestVo
    ) {
        ColorResponseVo result = colorService.saveColor(ColorRequestDto.from(colorRequestVo)).toVo();
        return new BaseResponseEntity<>("색상이 추가되었습니다.", result);
    }

    // 2. Color 전체 조회
    @GetMapping
    public BaseResponseEntity<List<ColorResponseVo>> getAllColors() {

        List<ColorResponseVo> result = colorService.findAllColors()
                .stream().map(ColorResponseDto::toVo).toList();

        return new BaseResponseEntity<>("색상 전체 조회에 성공하였습니다.", result);
    }

    // 3. Color 단건 조회
    @GetMapping("/{colorId}")
    public BaseResponseEntity<ColorResponseVo> getColor(
            @PathVariable Long colorId
    ) {
        ColorResponseVo result = colorService.findByColorId(colorId).toVo();
        return new BaseResponseEntity<>("색상 조회에 성공하였습니다.", result);
    }

    // 4. Color 수정
    @PutMapping("/{colorId}")
    public BaseResponseEntity<ColorResponseVo> updateColor(
        @PathVariable Long colorId,
        @RequestBody ColorRequestVo colorRequestVo
    ) {
        ColorResponseVo result = colorService.updateColor(
                colorId,
                ColorRequestDto.from(colorRequestVo)
        ).toVo();
        return new BaseResponseEntity<>("색상 정보를 변경하였습니다.", result);
    }

    // 5. Color 삭제
    @DeleteMapping("/{colorId}")
    public BaseResponseEntity<BaseResponseEntity> deleteColor(
        @PathVariable Long colorId
    ) {
        colorService.deleteColor(colorId);
        return new BaseResponseEntity<>("색상이 삭제되었습니다.", null);
    }
}
