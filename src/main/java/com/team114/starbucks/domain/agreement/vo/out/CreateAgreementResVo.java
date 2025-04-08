package com.team114.starbucks.domain.agreement.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateAgreementResVo {

    private String agreementName;

    @Builder
    public CreateAgreementResVo(String agreementName) {
        this.agreementName = agreementName;
    }
}
