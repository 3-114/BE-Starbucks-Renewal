package com.team114.starbucks.domain.oauth2.infrastructure;

import com.team114.starbucks.domain.oauth2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {



}
