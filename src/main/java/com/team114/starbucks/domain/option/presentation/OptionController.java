package com.team114.starbucks.domain.option.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.option.application.OptionService;
import com.team114.starbucks.domain.option.dto.in.CreateOptionReqDto;
import com.team114.starbucks.domain.option.dto.in.UpdateOptionReqDto;
import com.team114.starbucks.domain.option.dto.out.OptionResponseDto;
import com.team114.starbucks.domain.option.vo.in.CreateOptionReqVo;
import com.team114.starbucks.domain.option.vo.in.UpdateOptionReqVo;
import com.team114.starbucks.domain.option.vo.out.GetAllOptionResVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/options")
public class OptionController {

    private final OptionService optionService;

    /**
     * 1. 옵션 생성
     * 2. 옵션 전체 조회
     * 3. 옵션 단건 조회
     * 4. 옵션 수정
     * 5. 옵션 삭제
     */

    /**
     * 1. 옵션 생성
     *
     * @param createOptionReqVo 옵션 생성 데이터
     * @return {@link BaseResponseEntity} 옵션 생성 결과
     */
    @Operation(summary = "옵션 생성", tags = {"Option"})
    @PostMapping
    public BaseResponseEntity<GetAllOptionResVo> createOption(
            @RequestBody CreateOptionReqVo createOptionReqVo
    ) {
        optionService.saveOption(CreateOptionReqDto.from(createOptionReqVo));
        return new BaseResponseEntity<>("옵션이 등록되었습니다.");
    }

    /**
     * 2. 옵션 전체 조회
     *
     * @return {@link BaseResponseEntity} 옵션 전체 조회 결과
     */
    @Operation(summary = "옵션 전체 조회", tags = {"Option"})
    @GetMapping
    public BaseResponseEntity<List<GetAllOptionResVo>> getAllOptions() {
        List<GetAllOptionResVo> result = optionService.findAllOptions()
                .stream().map(OptionResponseDto::toVo).toList();
        return new BaseResponseEntity<>("옵션이 전체 조회에 성공했습니다.", result);
    }

    /**
     * 3. 옵션 단건 조회
     *
     * @param optionId 옵션 ID
     * @return {@link BaseResponseEntity} 옵션 단건 조회 결과
     */
    @Operation(summary = "옵션 단건 조회", tags = {"Option"})
    @GetMapping("/{optionId}")
    public BaseResponseEntity<GetAllOptionResVo> getOption(
            @PathVariable Long optionId
    ) {
        GetAllOptionResVo result = optionService.findOptionById(optionId).toVo();
        return new BaseResponseEntity<>("옵션이 단건 조회에 성공했습니다.", result);
    }

    /**
     * 4. 옵션 수정
     *
     * @param updateOptionReqVo 옵션 수정 데이터
     * @return {@link BaseResponseEntity} 옵션 단건 조회 결과
     */
    @Operation(summary = "옵션 수정", tags = {"Option"})
    @PutMapping
    public BaseResponseEntity<GetAllOptionResVo> updateOption(
            @RequestBody UpdateOptionReqVo updateOptionReqVo
    ) {
        optionService.updateOption(UpdateOptionReqDto.from(updateOptionReqVo));

        return new BaseResponseEntity<>("옵션 정보가 수정되었습니다.");
    }

    /**
     * 5. 옵션 삭제
     *
     * @param optionId 옵션 ID
     * @return {@link BaseResponseEntity} 옵션 삭제 조회 결과
     */
    @Operation(summary = "옵션 삭제", tags = {"Option"})
    @DeleteMapping("/{optionId}")
    public BaseResponseEntity<Void> deleteOption(
            @PathVariable Long optionId
    ) {
        optionService.deleteOption(optionId);
        return new BaseResponseEntity<>("옵션이 삭제되었습니다.", null);
    }

}