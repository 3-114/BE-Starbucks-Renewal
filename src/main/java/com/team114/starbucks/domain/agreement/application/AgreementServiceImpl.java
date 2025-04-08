package com.team114.starbucks.domain.agreement.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.agreement.dto.in.CreateAgreementReqDto;
import com.team114.starbucks.domain.agreement.dto.out.CreateAgreementResDto;
import com.team114.starbucks.domain.agreement.dto.out.GetAgreementResDto;
import com.team114.starbucks.domain.agreement.entity.Agreement;
import com.team114.starbucks.domain.agreement.infrastructure.AgreementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {
    private final AgreementRepository agreementRepository;

    @Transactional
    @Override
    public CreateAgreementResDto saveAgreement(CreateAgreementReqDto createAgreementReqDto) {
        try {
            Agreement savedagreement = agreementRepository.save(createAgreementReqDto.toEntity(UUID.randomUUID().toString()));

            return CreateAgreementResDto.from(savedagreement);
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_SAVE);
        }
    }

    @Override
    public GetAgreementResDto findAgreement(String agreementUuid) {
        // agreementUuid로 agreement 조회
        Agreement agreement = agreementRepository.findByAgreementUuid(agreementUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        // agreement -> Dto
        return GetAgreementResDto.from(agreement);

    }
}
