package com.team114.starbucks.domain.agreement.vo.out;

import com.team114.starbucks.domain.agreement.enums.AgreementType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetAllAgreementsResVo {

    private String agreementName;
    private AgreementType agreementType;

    @Builder
    public GetAllAgreementsResVo(String agreementName, AgreementType agreementType) {
        this.agreementName = agreementName;
        this.agreementType = agreementType;
    }
}
