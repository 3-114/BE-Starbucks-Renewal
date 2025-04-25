package com.team114.starbucks.domain.size.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.size.application.SizeService;
import com.team114.starbucks.domain.size.dto.in.GetAllSizeReqDto;
import com.team114.starbucks.domain.size.dto.out.GetAllSizeResDto;
import com.team114.starbucks.domain.size.vo.in.GetAllSizeReqVo;
import com.team114.starbucks.domain.size.vo.out.GetAllSizeResVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sizes")
public class SizeController {

    private final SizeService sizeService;

    /**
     * 1. 사이즈 생성
     * 2. 사이즈 전체 조회
     * 3. 사이즈 단건 조회
     * 4. 사이즈 수정
     * 5. 사이즈 삭제
     */

    /**
     * 1. 사이즈 생성
     *
     * @param getAllSizeReqVo 사이즈 데이터
     * @return {@link BaseResponseEntity} 사이즈 생성 결과
     */
    @Operation(summary = "사이즈 생성", tags = {"Size"})
    @PostMapping
    public BaseResponseEntity<GetAllSizeResVo> createSize(
            @RequestBody GetAllSizeReqVo getAllSizeReqVo
    ) {
        GetAllSizeResVo result = sizeService.saveSize(GetAllSizeReqDto.from(getAllSizeReqVo)).toVo();
        return new BaseResponseEntity<>("사이즈가 생성되었습니다.", result);
    }

    /**
     * 1. 사이즈 전체 조회
     *
     * @return {@link BaseResponseEntity} 사이즈 전체 조회 결과
     */
    @Operation(summary = "사이즈 전체 조회", tags = {"Size"})
    @GetMapping
    public BaseResponseEntity<List<GetAllSizeResVo>> getAllSizes() {
        List<GetAllSizeResVo> result = sizeService.findAllSizes()
                .stream().map(GetAllSizeResDto::toVo).toList();

        return new BaseResponseEntity<>("사이즈 전체 조회에 성공하였습니다.", result);
    }

    /**
     * 3. 사이즈 단건 조회
     *
     * @param sizeId 사이즈 ID
     * @return {@link BaseResponseEntity} 사이즈 단건 조회 결과
     */
    @Operation(summary = "사이즈 단건 조회", tags = {"Size"})
    @GetMapping("/{sizeId}")
    public BaseResponseEntity<GetAllSizeResVo> getSize(
            @PathVariable Long sizeId
    ) {
        GetAllSizeResVo result = sizeService.findBySizeId(sizeId).toVo();
        return new BaseResponseEntity<>("사이즈 단건 조회에 성공하였습니다.", result);
    }

    /**
     * 4. 사이즈 수정
     *
     * @param getAllSizeReqVo 사이즈 수정 데이터
     * @return {@link BaseResponseEntity} 사이즈 수정 결과
     */
    @Operation(summary = "사이즈 정보 변경", tags = {"Size"})
    @PutMapping("/{sizeId}")
    public BaseResponseEntity<GetAllSizeResVo> updateSize(
            @PathVariable Long sizeId,
            @RequestBody GetAllSizeReqVo getAllSizeReqVo
    ) {
        GetAllSizeResVo result = sizeService.updateSize(
                sizeId,
                GetAllSizeReqDto.from(getAllSizeReqVo)
        ).toVo();
        return new BaseResponseEntity<>("사이즈 정보를 변경하였습니다.", result);
    }

    /**
     * 5. 사이즈 삭제
     *
     * @param sizeId 사이즈 ID
     * @return {@link BaseResponseEntity} 사이즈 삭제 결과
     */
    @Operation(summary = "사이즈 삭제", tags = {"Size"})
    @DeleteMapping("/{sizeId}")
    public BaseResponseEntity<Void> deleteSize(
            @PathVariable Long sizeId
    ) {
        sizeService.deleteSize(sizeId);
        return new BaseResponseEntity<>("사이즈가 삭제되었습니다.", null);
    }

}