package com.team114.starbucks.domain.agreement.application;

import com.team114.starbucks.domain.agreement.dto.in.CreateAgreementReqDto;
import com.team114.starbucks.domain.agreement.dto.out.CreateAgreementResDto;
import com.team114.starbucks.domain.agreement.dto.out.GetAgreementResDto;
import com.team114.starbucks.domain.agreement.dto.out.GetAllAgreementsResDto;
import com.team114.starbucks.domain.agreement.vo.in.UpdateAgreementReqVo;
import com.team114.starbucks.domain.agreement.vo.out.GetAgreementResVo;
import com.team114.starbucks.domain.agreement.vo.out.GetAllAgreementsResVo;

import java.util.List;

public interface AgreementService {
    CreateAgreementResDto saveAgreement(CreateAgreementReqDto createAgreementReqDto);

    GetAgreementResDto findAgreement(String agreementUuid);

    List<GetAllAgreementsResDto> findAllAgreements();

    Void updateAgreement(String agreementUuid, UpdateAgreementReqVo updateAgreementReqVo);
}
