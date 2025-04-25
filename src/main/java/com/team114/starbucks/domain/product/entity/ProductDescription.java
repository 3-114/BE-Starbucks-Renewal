package com.team114.starbucks.domain.product.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class ProductDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String productUuid;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String productDescription;

    @Builder
    public ProductDescription(Long id, String productDescription, String productUuid) {
        this.id = id;
        this.productUuid = productUuid;
        this.productDescription = productDescription;
    }

}