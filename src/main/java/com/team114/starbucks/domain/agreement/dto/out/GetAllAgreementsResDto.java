package com.team114.starbucks.domain.agreement.dto.out;

import com.team114.starbucks.domain.agreement.entity.Agreement;
import com.team114.starbucks.domain.agreement.enums.AgreementType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetAllAgreementsResDto {

    private String agreementName;
    private AgreementType agreementType;

    @Builder
    public GetAllAgreementsResDto(String agreementName, AgreementType agreementType) {
        this.agreementName = agreementName;
        this.agreementType = agreementType;
    }

    public static GetAllAgreementsResDto from(Agreement agreement) {

        return GetAllAgreementsResDto.builder()
                .agreementName(agreement.getAgreementName())
                .agreementType(agreement.getAgreementType())
                .build();
    }
}
