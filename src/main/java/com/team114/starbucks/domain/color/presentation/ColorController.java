package com.team114.starbucks.domain.color.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.color.application.ColorService;
import com.team114.starbucks.domain.color.dto.in.ColorRequestDto;
import com.team114.starbucks.domain.color.dto.out.ColorResponseDto;
import com.team114.starbucks.domain.color.vo.in.CreateColorReqVo;
import com.team114.starbucks.domain.color.vo.out.CreateColorResVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/color")
public class ColorController {

    private final ColorService colorService;

    /**
     * 1. Color 생성
     * 2. Color 전체 조회
     * 3. Color 단건 조회
     * 4. Color 수정
     * 5. Color 삭제
     */

    /**
     * 1. Color 생성
     *
     * @param createColorReqVo 색상 정보
     * @return {@link BaseResponseEntity} 색상 생성 결과
     */
    @Operation(summary = "새로운 색상 생성", tags = {"Color"})
    @PostMapping
    public BaseResponseEntity<CreateColorResVo> createColor(
            @RequestBody CreateColorReqVo createColorReqVo
    ) {
        CreateColorResVo result = colorService.saveColor(ColorRequestDto.from(createColorReqVo)).toVo();
        return new BaseResponseEntity<>("색상이 추가되었습니다.", result);
    }

    /**
     * 2. Color 전체 조회
     *
     * @return {@link BaseResponseEntity} 색상 조회 결과
     */
    @Operation(summary = "색상 전체 조회", tags = {"Color"})
    @GetMapping
    public BaseResponseEntity<List<CreateColorResVo>> getAllColors() {
        List<CreateColorResVo> result = colorService.findAllColors()
                .stream().map(ColorResponseDto::toVo).toList();

        return new BaseResponseEntity<>("색상 전체 조회에 성공하였습니다.", result);
    }

    /**
     * 3. Color 단건 조회
     *
     * @param colorId 색상 ID
     * @return {@link BaseResponseEntity} 색상 조회 결과
     */
    @Operation(summary = "색상 단건 조회", tags = {"Color"})
    @GetMapping("/{colorId}")
    public BaseResponseEntity<CreateColorResVo> getColor(
            @PathVariable Long colorId
    ) {
        CreateColorResVo result = colorService.findByColorId(colorId).toVo();
        return new BaseResponseEntity<>("색상 조회에 성공하였습니다.", result);
    }

    /**
     * 4. Color 수정
     *
     * @param colorId 색상 ID
     * @return {@link BaseResponseEntity} 색상 조회 결과
     */
    @Operation(summary = "색상 수정", tags = {"Color"})
    @PutMapping("/{colorId}")
    public BaseResponseEntity<CreateColorResVo> updateColor(
        @PathVariable Long colorId,
        @RequestBody CreateColorReqVo createColorReqVo
    ) {
        CreateColorResVo result = colorService.updateColor(
                colorId,
                ColorRequestDto.from(createColorReqVo)
        ).toVo();
        return new BaseResponseEntity<>("색상 정보를 변경하였습니다.", result);
    }

    /**
     * 5. Color 삭제
     *
     * @param colorId 색상 ID
     * @return {@link BaseResponseEntity} 색상 삭제 결과
     */
    @Operation(summary = "색상 삭제", tags = {"Color"})
    @DeleteMapping("/{colorId}")
    public BaseResponseEntity<Void> deleteColor(
        @PathVariable Long colorId
    ) {
        colorService.deleteColor(colorId);
        return new BaseResponseEntity<>("색상이 삭제되었습니다.", null);
    }
}
