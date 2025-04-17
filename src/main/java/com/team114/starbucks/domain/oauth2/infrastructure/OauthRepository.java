package com.team114.starbucks.domain.oauth2.infrastructure;

import com.team114.starbucks.domain.oauth2.entity.OauthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthRepository extends JpaRepository<OauthEntity, Long> {



}
