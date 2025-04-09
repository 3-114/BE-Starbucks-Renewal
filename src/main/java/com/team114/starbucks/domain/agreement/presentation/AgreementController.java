package com.team114.starbucks.domain.agreement.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.agreement.application.AgreementService;
import com.team114.starbucks.domain.agreement.dto.in.CreateAgreementReqDto;
import com.team114.starbucks.domain.agreement.dto.out.CreateAgreementResDto;
import com.team114.starbucks.domain.agreement.dto.out.GetAgreementResDto;
import com.team114.starbucks.domain.agreement.dto.out.GetAllAgreementsResDto;
import com.team114.starbucks.domain.agreement.vo.in.CreateAgreementReqVo;
import com.team114.starbucks.domain.agreement.vo.in.UpdateAgreementReqVo;
import com.team114.starbucks.domain.agreement.vo.out.CreateAgreementResVo;
import com.team114.starbucks.domain.agreement.vo.out.GetAgreementResVo;
import com.team114.starbucks.domain.agreement.vo.out.GetAllAgreementsResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/agreement")
public class AgreementController {

    /**
     * 1. 동의 항목 생성
     * 2. 동의 항목 단건 조회
     * 3. 동의 항목 전체 리스트 조회
     * 4. 동의 항목 정보 변경
     * 5. 동의 항목 삭제
     */

    private final AgreementService agreementService;

    /**
     * 1. 동의 항목 생성
     *
     * @param createAgreementReqVo
     * @return
     */
    @PostMapping
    public BaseResponseEntity<CreateAgreementResVo> createAgreement(
            @RequestBody CreateAgreementReqVo createAgreementReqVo
    ) {

//        CreateAgreementReqDto.from(createAgreementReqVo)
        CreateAgreementResDto createAgreementResDto = agreementService.saveAgreement(CreateAgreementReqDto.from(createAgreementReqVo));
        CreateAgreementResVo createAgreementResVo = createAgreementResDto.toVo();
        return new BaseResponseEntity<>("동의항목 생성에 성공했습니다. ", createAgreementResVo);
    }

    /**
     * 2. 동의 항목 단건 조회
     *
     * @param agreementUuid
     * @return
     */
    @GetMapping("/{agreementUuid}")
    public BaseResponseEntity<GetAgreementResVo> findAgreement(
            @PathVariable String agreementUuid
    ) {
        GetAgreementResDto getAgreementResDto = agreementService.findAgreement(agreementUuid);

        GetAgreementResVo getAgreementResVo = getAgreementResDto.toVo();

        return new BaseResponseEntity<>("동의항목 단건 조회에 성공하였습니다.", getAgreementResVo);
    }

    /**
     * 3. 동의 항목 전체 리스트 조회
     *
     * @return
     */
    @GetMapping
    public BaseResponseEntity<List<GetAllAgreementsResVo>> findAllAgreements() {

        List<GetAllAgreementsResDto> dtoList = agreementService.findAllAgreements();

        List<GetAllAgreementsResVo> result = new ArrayList<>();

        for (GetAllAgreementsResDto dto : dtoList) {
            result.add(GetAllAgreementsResVo.builder()
                    .agreementName(dto.getAgreementName())
                    .agreementType(dto.getAgreementType())
                    .build());
        }

        return new BaseResponseEntity<>("동의항목 전체 리스트 조회에 성공하였습니다.", result);
    }

    /**
     * 4. 동의 항목 정보 변경
     * @param agreementUuid
     * @param updateAgreementReqVo
     * @return
     */
    @PutMapping("/{agreementUuid}")
    public BaseResponseEntity<Void> updateAgreement(
            @PathVariable String agreementUuid,
            @RequestBody UpdateAgreementReqVo updateAgreementReqVo
    ) {
        agreementService.updateAgreement(agreementUuid, updateAgreementReqVo);
        return new BaseResponseEntity<>("동의항목 정보 변경에 성공하였습니다.", null);
    }

    @DeleteMapping("/{agreementUuid}")
    public BaseResponseEntity<Void> deleteAgreement(
            @PathVariable String agreementUuid
    ) {
        agreementService.deleteAgreement(agreementUuid);

        return new BaseResponseEntity<>("동의항목 삭제에 성공하였습니다.", null);
    }
}
