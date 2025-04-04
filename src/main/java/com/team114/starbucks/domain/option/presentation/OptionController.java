package com.team114.starbucks.domain.option.presentation;

import com.team114.starbucks.common.entity.BaseResponseEntity;
import com.team114.starbucks.domain.option.application.OptionService;
import com.team114.starbucks.domain.option.dto.out.OptionResponseDto;
import com.team114.starbucks.domain.option.vo.out.OptionResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/option")
public class OptionController {

    private final OptionService optionService;

    @Operation(summary = "상품옵션 목록 조회", description = "상품코드 기반으로 옵션 목록 조회")
    @GetMapping("/{productUuid}")
    public BaseResponseEntity<List<OptionResponseVo>> getOptionsByProductUuid(
            @PathVariable String productUuid) {
        List<OptionResponseVo> result = optionService.findOptionsByProductUuid(productUuid)
                .stream().map(OptionResponseDto::toVo).toList();

        return new BaseResponseEntity<>("옵션 조회에 성공하였습니다.", result);
    }

    @Operation(summary = "옵션 전체 조회", description = "전체 옵션을 조회합니다.")
    @GetMapping
    public BaseResponseEntity<List<OptionResponseVo>> getAllOptions() {
        List<OptionResponseVo> result = optionService.findAllOptions()
                .stream().map(OptionResponseDto::toVo).toList();

        return new BaseResponseEntity<>("옵션 전체 조회에 성공하였습니다.", result);
    }
}
