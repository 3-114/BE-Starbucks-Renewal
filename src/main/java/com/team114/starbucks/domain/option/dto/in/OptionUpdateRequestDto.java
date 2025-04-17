package com.team114.starbucks.domain.option.dto.in;

import com.team114.starbucks.domain.option.entity.Option;
import com.team114.starbucks.domain.option.vo.in.OptionUpdateRequestVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OptionUpdateRequestDto {

    private Long optionId;
    private Integer stock;
    private Long optionPrice;
    private Integer discountRate;

    @Builder
    public OptionUpdateRequestDto(
            Long optionId,
            Integer stock,
            Long optionPrice,
            Integer discountRate
    ) {
        this.optionId = optionId;
        this.stock = stock;
        this.optionPrice = optionPrice;
        this.discountRate = discountRate;
    }

    public static OptionUpdateRequestDto from(
            OptionUpdateRequestVo optionUpdateRequestVo
    ) {
        return OptionUpdateRequestDto.builder()
                .optionId(optionUpdateRequestVo.getOptionId())
                .stock(optionUpdateRequestVo.getStock())
                .optionPrice(optionUpdateRequestVo.getOptionPrice())
                .discountRate(optionUpdateRequestVo.getDiscountRate())
                .build();
    }

    public Option toEntity(Option option) {

        return Option.builder()
                .optionId(option.getOptionId())
                .productUuid(option.getProductUuid())
                .color(option.getColor())
                .size(option.getSize())
                .stock(stock)
                .optionPrice(optionPrice)
                .discountRate(discountRate)
                .build();

    }
}
