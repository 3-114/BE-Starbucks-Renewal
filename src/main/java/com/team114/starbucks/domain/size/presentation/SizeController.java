package com.team114.starbucks.domain.size.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.size.application.SizeService;
import com.team114.starbucks.domain.size.dto.in.SizeRequestDto;
import com.team114.starbucks.domain.size.dto.out.SizeResponseDto;
import com.team114.starbucks.domain.size.vo.in.SizeRequestVo;
import com.team114.starbucks.domain.size.vo.out.SizeResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sizes")
public class SizeController {

    private final SizeService sizeService;

    @Operation(summary = "사이즈 생성", tags = {"Size"})
    @PostMapping
    public BaseResponseEntity<SizeResponseVo> createSize(
            @RequestBody SizeRequestVo sizeRequestVo
    ) {
        SizeResponseVo result = sizeService.saveSize(SizeRequestDto.from(sizeRequestVo)).toVo();
        return new BaseResponseEntity<>("사이즈가 생성되었습니다.", result);
    }

    @Operation(summary = "사이즈 전체 조회", tags = {"Size"})
    @GetMapping
    public BaseResponseEntity<List<SizeResponseVo>> getAllSizes() {
        List<SizeResponseVo> result = sizeService.findAllSizes()
                .stream().map(SizeResponseDto::toVo).toList();

        return new BaseResponseEntity<>("사이즈 전체 조회에 성공하였습니다.", result);
    }

    @Operation(summary = "사이즈 단건 조회", tags = {"Size"})
    @GetMapping("/{sizeId}")
    public BaseResponseEntity<SizeResponseVo> getSize(
            @PathVariable Long sizeId
    ) {
        SizeResponseVo result = sizeService.findBySizeId(sizeId).toVo();
        return new BaseResponseEntity<>("사이즈 단건 조회에 성공하였습니다.", result);
    }

    @Operation(summary = "사이즈 정보 변경", tags = {"Size"})
    @PutMapping("/{sizeId}")
    public BaseResponseEntity<SizeResponseVo> updateSize(
            @PathVariable Long sizeId,
            @RequestBody SizeRequestVo sizeRequestVo
    ) {
        SizeResponseVo result = sizeService.updateSize(
                sizeId,
                SizeRequestDto.from(sizeRequestVo)
        ).toVo();
        return new BaseResponseEntity<>("사이즈 정보를 변경하였습니다.", result);
    }

    @Operation(summary = "사이즈 삭제", tags = {"Size"})
    @DeleteMapping("/{sizeId}")
    public BaseResponseEntity<Void> deleteSize(
            @PathVariable Long sizeId
    ) {
        sizeService.deleteSize(sizeId);
        return new BaseResponseEntity<>("사이즈가 삭제되었습니다.", null);
    }
}
