package com.team114.starbucks.domain.agreement.application;

import com.team114.starbucks.domain.agreement.dto.in.CreateAgreementReqDto;
import com.team114.starbucks.domain.agreement.dto.out.CreateAgreementResDto;
import com.team114.starbucks.domain.agreement.dto.out.GetAgreementResDto;

public interface AgreementService {
    CreateAgreementResDto saveAgreement(CreateAgreementReqDto createAgreementReqDto);

    GetAgreementResDto findAgreement(String agreementUuid);
}
