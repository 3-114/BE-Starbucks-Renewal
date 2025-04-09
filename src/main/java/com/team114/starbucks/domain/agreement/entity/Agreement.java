package com.team114.starbucks.domain.agreement.entity;

import com.team114.starbucks.common.entity.BaseEntity;
import com.team114.starbucks.domain.agreement.enums.AgreementGroup;
import com.team114.starbucks.domain.agreement.enums.AgreementType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Agreement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String agreementUuid;

    private String agreementName;

    private AgreementGroup agreementGroup;

    private String agreementURL;

    private AgreementType agreementType;

    @Builder
    public Agreement(Long id, String agreementUuid, String agreementName, AgreementGroup agreementGroup, String agreementURL, AgreementType agreementType) {
        this.id = id;
        this.agreementUuid = agreementUuid;
        this.agreementName = agreementName;
        this.agreementGroup = agreementGroup;
        this.agreementURL = agreementURL;
        this.agreementType = agreementType;
    }
}
