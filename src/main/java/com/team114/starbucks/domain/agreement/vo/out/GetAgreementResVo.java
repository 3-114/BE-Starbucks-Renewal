package com.team114.starbucks.domain.agreement.vo.out;

import com.team114.starbucks.domain.agreement.enums.AgreementGroup;
import com.team114.starbucks.domain.agreement.enums.AgreementType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetAgreementResVo {

    private String agreementName;
    private AgreementGroup agreementGroup;
    private AgreementType agreementType;

    @Builder
    public GetAgreementResVo(String agreementName, AgreementGroup agreementGroup, AgreementType agreementType) {
        this.agreementName = agreementName;
        this.agreementGroup = agreementGroup;
        this.agreementType = agreementType;
    }
}
