package com.team114.starbucks.domain.option.entity;

import com.team114.starbucks.domain.option.eunms.Capacity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.type.descriptor.sql.internal.CapacityDependentDdlType;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String sizeName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Capacity capacity;
}
