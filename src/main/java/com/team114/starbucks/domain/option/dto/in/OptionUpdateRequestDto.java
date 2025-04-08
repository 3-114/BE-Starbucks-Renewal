package com.team114.starbucks.domain.option.dto.in;

import com.team114.starbucks.domain.color.entity.Color;
import com.team114.starbucks.domain.option.entity.Option;
import com.team114.starbucks.domain.option.vo.in.OptionCreateRequestVo;
import com.team114.starbucks.domain.option.vo.in.OptionUpdateRequestVo;
import com.team114.starbucks.domain.size.entity.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OptionUpdateRequestDto {

    private String productUuid;
    private Long colorId;
    private Long sizeId;
    private Integer stock;
    private Long optionPrice;
    private Integer discountRate;

    @Builder
    public OptionUpdateRequestDto(
            String productUuid,
            Long colorId,
            Long sizeId,
            Integer stock,
            Long optionPrice,
            Integer discountRate
    ) {
        this.productUuid = productUuid;
        this.colorId = colorId;
        this.sizeId = sizeId;
        this.stock = stock;
        this.optionPrice = optionPrice;
        this.discountRate = discountRate;
    }

    public static OptionUpdateRequestDto from(
            OptionUpdateRequestVo optionUpdateRequestVo
    ) {
        return OptionUpdateRequestDto.builder()
                .productUuid(optionUpdateRequestVo.getProductUuid())
                .colorId(optionUpdateRequestVo.getColorId())
                .sizeId(optionUpdateRequestVo.getSizeId())
                .optionPrice(optionUpdateRequestVo.getOptionPrice())
                .discountRate(optionUpdateRequestVo.getDiscountRate())
                .build();
    }

    public Option toEntity(Long optionId, Color color, Size size) {

        return Option.builder()
                .optionId(optionId)
                .productUuid(productUuid)
                .color(color)
                .size(size)
                .stock(stock)
                .optionPrice(optionPrice)
                .discountRate(discountRate)
                .build();

    }
}
