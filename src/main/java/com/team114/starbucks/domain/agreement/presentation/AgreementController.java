package com.team114.starbucks.domain.agreement.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.agreement.application.AgreementService;
import com.team114.starbucks.domain.agreement.dto.in.CreateAgreementReqDto;
import com.team114.starbucks.domain.agreement.dto.out.CreateAgreementResDto;
import com.team114.starbucks.domain.agreement.dto.out.GetAgreementResDto;
import com.team114.starbucks.domain.agreement.vo.in.CreateAgreementReqVo;
import com.team114.starbucks.domain.agreement.vo.out.CreateAgreementResVo;
import com.team114.starbucks.domain.agreement.vo.out.GetAgreementResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/agreement")
public class AgreementController {

    private final AgreementService agreementService;

    @PostMapping
    public BaseResponseEntity<CreateAgreementResVo> createAgreement(
            @RequestBody CreateAgreementReqVo createAgreementReqVo
    ) {

//        CreateAgreementReqDto.from(createAgreementReqVo)
        CreateAgreementResDto createAgreementResDto = agreementService.saveAgreement(CreateAgreementReqDto.from(createAgreementReqVo));
        CreateAgreementResVo createAgreementResVo = createAgreementResDto.toVo();
        return new BaseResponseEntity<>("동의항목 생성에 성공했습니다. ",createAgreementResVo);
    }

    @GetMapping("/{agreementUuid}")
    public BaseResponseEntity<GetAgreementResVo> findAgreement(
            @PathVariable String agreementUuid
    ) {
        GetAgreementResDto getAgreementResDto = agreementService.findAgreement(agreementUuid);

        GetAgreementResVo getAgreementResVo = getAgreementResDto.toVo();

        return new BaseResponseEntity<>("동의항목 단건 조회에 성공하였습니다.", getAgreementResVo);
    }

}
