package com.team114.starbucks.domain.option.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.option.application.OptionService;
import com.team114.starbucks.domain.option.dto.in.OptionCreateRequestDto;
import com.team114.starbucks.domain.option.dto.in.OptionUpdateRequestDto;
import com.team114.starbucks.domain.option.dto.out.OptionResponseDto;
import com.team114.starbucks.domain.option.vo.in.OptionCreateRequestVo;
import com.team114.starbucks.domain.option.vo.in.OptionUpdateRequestVo;
import com.team114.starbucks.domain.option.vo.out.OptionResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/options")
public class OptionController {

    private final OptionService optionService;

    // 1. 옵션 등록
    @PostMapping
    public BaseResponseEntity<OptionResponseVo> createOption(
            @RequestBody OptionCreateRequestVo optionCreateRequestVo
    ) {
        OptionResponseVo result = optionService.saveOption(OptionCreateRequestDto.from(optionCreateRequestVo)).toVo();
        return new BaseResponseEntity<>("옵션이 등록되었습니다.", result);
    }

    // 2. 옵션 전체 조회
    @GetMapping
    public BaseResponseEntity<List<OptionResponseVo>> getAllOptions() {
        List<OptionResponseVo> result = optionService.findAllOptions()
                .stream().map(OptionResponseDto::toVo).toList();
        return new BaseResponseEntity<>("옵션이 전체 조회에 성공했습니다.", result);
    }

    // 3. 옵션 단건 조회
    @GetMapping("/{optionId}")
    public BaseResponseEntity<OptionResponseVo> getOption(
            @PathVariable Long optionId
    ) {
        OptionResponseVo result = optionService.findOptionById(optionId).toVo();
        return new BaseResponseEntity<>("옵션이 단건 조회에 성공했습니다.", result);
    }

    // 4. 옵션 수정
    @PutMapping("/{optionId}")
    public BaseResponseEntity<OptionResponseVo> updateOption(
            @PathVariable Long optionId,
            @RequestBody OptionUpdateRequestVo optionUpdateRequestVo
    ) {
        OptionResponseVo result = optionService.updateOption(
                optionId,
                OptionUpdateRequestDto.from(optionUpdateRequestVo)
        ).toVo();
        return new BaseResponseEntity<>("옵션 정보가 수정되었습니다.", result);
    }

    // 5. 옵션 삭제
    @DeleteMapping("/{optionId}")
    public BaseResponseEntity<Void> deleteOption(
            @PathVariable Long optionId
    ) {
        optionService.deleteOption(optionId);
        return new BaseResponseEntity<>("옵션이 삭제되었습니다.", null);
    }
}
