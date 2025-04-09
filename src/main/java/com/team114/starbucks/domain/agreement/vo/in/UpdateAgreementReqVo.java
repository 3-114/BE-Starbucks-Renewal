package com.team114.starbucks.domain.agreement.vo.in;

import com.team114.starbucks.domain.agreement.enums.AgreementGroup;
import com.team114.starbucks.domain.agreement.enums.AgreementType;
import lombok.Getter;

@Getter
public class UpdateAgreementReqVo {

    private String agreementName;
    private AgreementGroup agreementGroup;
    private AgreementType agreementType;

}
