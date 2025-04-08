package com.team114.starbucks.domain.agreement.dto.out;

import com.team114.starbucks.domain.agreement.dto.in.CreateAgreementReqDto;
import com.team114.starbucks.domain.agreement.entity.Agreement;
import com.team114.starbucks.domain.agreement.vo.out.CreateAgreementResVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateAgreementResDto {

    private String agreementName;

    @Builder
    public CreateAgreementResDto(String agreementName) {
        this.agreementName = agreementName;
    }

    public static CreateAgreementResDto from(Agreement savedagreement) {
        return CreateAgreementResDto.builder()
                .agreementName(savedagreement.getAgreementName())
                .build();

    }

    public CreateAgreementResVo toVo() {
        return CreateAgreementResVo.builder()
                .agreementName(agreementName)
                .build();
    }
}
