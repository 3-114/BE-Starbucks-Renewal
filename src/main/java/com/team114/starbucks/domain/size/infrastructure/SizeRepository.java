package com.team114.starbucks.domain.size.infrastructure;

import com.team114.starbucks.domain.size.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SizeRepository extends JpaRepository<Size, Long> {

    Optional<Size> findBySizeId(Long sizeId);

    Optional<Size> deleteBySizeId(Long sizeId);

}