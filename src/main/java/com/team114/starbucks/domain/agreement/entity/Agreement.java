package com.team114.starbucks.domain.agreement.entity;

import com.team114.starbucks.common.entity.BaseEntity;
import com.team114.starbucks.domain.agreement.enums.AgreementGroup;
import com.team114.starbucks.domain.agreement.enums.AgreementType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    private String agreementDescription;

    private String agreementDescriptionUrl;

    private AgreementType agreementType;

}
