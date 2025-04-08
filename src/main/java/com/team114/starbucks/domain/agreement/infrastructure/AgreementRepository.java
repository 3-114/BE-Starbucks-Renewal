package com.team114.starbucks.domain.agreement.infrastructure;

import com.team114.starbucks.domain.agreement.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgreementRepository extends JpaRepository<Agreement, Long> {
    Optional<Agreement> findByAgreementUuid(String agreementUuid);
}
