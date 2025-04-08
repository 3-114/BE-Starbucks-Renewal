package com.team114.starbucks.domain.agreement.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AgreementGroup {

    // 수집 항목 카테고리
    USAGE_INFORMATION("이용정보 수집"),
    PERSONAL_INFORMATION("개인정보 수집")
    ;

    private final String agreementType;

    @JsonValue
    public String getAgreementType() { return agreementType; }

    public static AgreementGroup getAgreementGroup(String value) {
        for (AgreementGroup agreementGroup : AgreementGroup.values()) {
            if (agreementGroup.getAgreementType().equals(value)) {
                return agreementGroup;
            }
        }
        throw new BaseException(BaseResponseStatus.NO_EXIST_VALUE);
    }
}
