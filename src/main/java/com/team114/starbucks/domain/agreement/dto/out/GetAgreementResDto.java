package com.team114.starbucks.domain.agreement.dto.out;

import com.team114.starbucks.domain.agreement.entity.Agreement;
import com.team114.starbucks.domain.agreement.enums.AgreementGroup;
import com.team114.starbucks.domain.agreement.enums.AgreementType;
import com.team114.starbucks.domain.agreement.vo.out.GetAgreementResVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetAgreementResDto {

    private String agreementName;
    private AgreementGroup agreementGroup;
    private AgreementType agreementType;


    @Builder
    public GetAgreementResDto(String agreementName, AgreementGroup agreementGroup, AgreementType agreementType) {
        this.agreementName = agreementName;
        this.agreementGroup = agreementGroup;
        this.agreementType = agreementType;
    }

    public static GetAgreementResDto from(Agreement agreement) {
        return GetAgreementResDto.builder()
                .agreementName(agreement.getAgreementName())
                .agreementGroup(agreement.getAgreementGroup())
                .agreementType(agreement.getAgreementType())
                .build();
    }

    public GetAgreementResVo toVo() {
        return GetAgreementResVo.builder()
                .agreementName(agreementName)
                .agreementGroup(agreementGroup)
                .agreementType(agreementType)
                .build();

    }
}
