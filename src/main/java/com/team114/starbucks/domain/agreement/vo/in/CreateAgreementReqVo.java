package com.team114.starbucks.domain.agreement.vo.in;

import com.team114.starbucks.domain.agreement.enums.AgreementGroup;
import com.team114.starbucks.domain.agreement.enums.AgreementType;
import lombok.Getter;

@Getter
public class CreateAgreementReqVo {

    private String agreementName;
    private AgreementGroup agreementGroup;
    private String agreementURL;
    private AgreementType agreementType;

}
