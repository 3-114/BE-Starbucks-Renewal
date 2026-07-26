package com.team114.starbucks.domain.option.dto.in;

import com.team114.starbucks.domain.option.entity.Option;
import com.team114.starbucks.domain.option.vo.in.UpdateOptionReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateOptionReqDto {

    private Long optionId;
    private Integer stock;
    private Long optionPrice;
    private Integer discountRate;

    @Builder
    public UpdateOptionReqDto(
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

    public static UpdateOptionReqDto from(UpdateOptionReqVo updateOptionReqVo) {
        return UpdateOptionReqDto.builder()
                .optionId(updateOptionReqVo.getOptionId())
                .stock(updateOptionReqVo.getStock())
                .optionPrice(updateOptionReqVo.getOptionPrice())
                .discountRate(updateOptionReqVo.getDiscountRate())
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