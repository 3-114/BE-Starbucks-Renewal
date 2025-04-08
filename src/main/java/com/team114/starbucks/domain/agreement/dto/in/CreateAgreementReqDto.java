package com.team114.starbucks.domain.agreement.dto.in;

import com.team114.starbucks.domain.agreement.entity.Agreement;
import com.team114.starbucks.domain.agreement.enums.AgreementGroup;
import com.team114.starbucks.domain.agreement.enums.AgreementType;
import com.team114.starbucks.domain.agreement.vo.in.CreateAgreementReqVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateAgreementReqDto {

    private String agreementName;
    private AgreementGroup agreementGroup;
    private String agreementURL;
    private AgreementType agreementType;

    @Builder
    public CreateAgreementReqDto(String agreementName, AgreementGroup agreementGroup, String agreementURL, AgreementType agreementType) {
        this.agreementName = agreementName;
        this.agreementGroup = agreementGroup;
        this.agreementURL = agreementURL;
        this.agreementType = agreementType;
    }

    public static CreateAgreementReqDto from(CreateAgreementReqVo createAgreementReqVo) {
        return CreateAgreementReqDto.builder()
                .agreementName(createAgreementReqVo.getAgreementName())
                .agreementGroup(createAgreementReqVo.getAgreementGroup())
                .agreementURL(createAgreementReqVo.getAgreementURL())
                .agreementType(createAgreementReqVo.getAgreementType())
                .build();

    }

    public Agreement toEntity(String agreementUuid) {
        return Agreement.builder()
                .agreementUuid(agreementUuid)
                .agreementName(agreementName)
                .agreementGroup(agreementGroup)
                .agreementURL(agreementURL)
                .agreementType(agreementType)
                .build();
    }
}
