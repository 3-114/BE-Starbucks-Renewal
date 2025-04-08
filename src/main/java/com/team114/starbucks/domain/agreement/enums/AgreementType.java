package com.team114.starbucks.domain.agreement.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AgreementType {

    AGREEMENT_TYPE_REQUIRED("필수"),
    AGREEMENT_TYPE_OPTIONAL("선택"),
    AGREEMENT_TYPE_OPTIONAL_AD("광고")
    ;

    private final String agreementType;

    @JsonValue
    public String getAgreementType() { return agreementType; }

    @JsonCreator
    public static AgreementType getAgreementType(String value) {
        for (AgreementType agreementType : AgreementType.values()) {
            if (agreementType.getAgreementType().equals(value)) {
                return agreementType;
            }
        }
        throw new BaseException(BaseResponseStatus.NO_EXIST_VALUE);
    }


}
