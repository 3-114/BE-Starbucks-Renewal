package com.team114.starbucks.domain.product.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    private String productDescription;

    private String productUuid;

    @Builder
    public ProductDescription(Long id, String productDescription, String productUuid) {
        this.id = id;
        this.productDescription = productDescription;
        this.productUuid = productUuid;
    }
}
