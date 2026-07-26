package com.team114.starbucks.domain.product.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductStatus {

    For_Sale("판매 중"),                 // 판매 중
    Sold_Out("품절"),                   // 품절
    Out_Of_Stock("일시 품절"),           // 일시품절
    Pre_Order("예약 판매"),              // 예약 판매
    Coming_Soon("입고 예정"),            // 입고 예정
    No_Longer_Available("판매 종료")     // 판매 종료
    ;

    private final String productStatus;

    @JsonValue
    public String getProductStatus() { return productStatus; }

    @JsonCreator
    public static ProductStatus fromString(String value) {
        for (ProductStatus productStatus : ProductStatus.values()) {
            if (productStatus.productStatus.equalsIgnoreCase(value)) {
                return productStatus;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }

}