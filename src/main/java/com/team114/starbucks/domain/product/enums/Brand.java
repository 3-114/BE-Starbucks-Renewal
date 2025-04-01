package com.team114.starbucks.domain.product.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Brand {

    BRAND_STARBUCKS("스타벅스")        // 스타벅스
    ;

    private final String brand;

    @JsonValue
    public String getBrand() { return brand; }

    @JsonCreator
    public static Brand fromString(String value) {
        for (Brand brand : Brand.values()) {
            if (brand.getBrand().equals(value)) {
                return brand;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
