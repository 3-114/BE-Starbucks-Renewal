package com.team114.starbucks.domain.color.infrastructure;

import com.team114.starbucks.domain.color.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color, Integer> {
    Optional<Color> findByColorId(Long colorId);
    Optional<Color> deleteByColorId(Long colorId);
}