package com.team114.starbucks.domain.agreement.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.agreement.dto.in.CreateAgreementReqDto;
import com.team114.starbucks.domain.agreement.dto.out.CreateAgreementResDto;
import com.team114.starbucks.domain.agreement.dto.out.GetAgreementResDto;
import com.team114.starbucks.domain.agreement.dto.out.GetAllAgreementsResDto;
import com.team114.starbucks.domain.agreement.entity.Agreement;
import com.team114.starbucks.domain.agreement.infrastructure.AgreementRepository;
import com.team114.starbucks.domain.agreement.vo.in.UpdateAgreementReqVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
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

    @Override
    public List<GetAllAgreementsResDto> findAllAgreements() {

        // 메서드 참조, 스트림 사용
        return agreementRepository.findAll().stream().map(GetAllAgreementsResDto::from).toList();

        // 반복문 사용
//        List<Agreement> agreementList = agreementRepository.findAll();
//
//        List<GetAllAgreementsResDto> dtoList = new ArrayList<>();
//
//        for (Agreement agreement : agreementList) {
//            dtoList.add(GetAllAgreementsResDto.builder()
//                            .agreementName(agreement.getAgreementName())
//                            .agreementType(agreement.getAgreementType())
//                            .build());
//        }
//
//        return  dtoList;

        // 람다, 스트림 사용
//        return agreementRepository.findAll().stream().map(agreement -> GetAllAgreementsResDto.from(agreement)).toList();

    }

    @Transactional
    @Override
    public Void updateAgreement(String agreementUuid, UpdateAgreementReqVo updateAgreementReqVo) {

        // uuid -> agreement
        Agreement agreement = agreementRepository.findByAgreementUuid(agreementUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        // 새 agreement 생성
        Agreement newAgreement = Agreement.builder()
                .id(agreement.getId())
                .agreementUuid(agreement.getAgreementUuid())
                .agreementName(updateAgreementReqVo == null ? agreement.getAgreementName() : updateAgreementReqVo.getAgreementName())
                .agreementGroup(updateAgreementReqVo == null ? agreement.getAgreementGroup() : updateAgreementReqVo.getAgreementGroup())
                .agreementType(updateAgreementReqVo == null ? agreement.getAgreementType() : updateAgreementReqVo.getAgreementType())
                .build();

        // save 호출
        agreementRepository.save(newAgreement);

        return null;
    }
}
