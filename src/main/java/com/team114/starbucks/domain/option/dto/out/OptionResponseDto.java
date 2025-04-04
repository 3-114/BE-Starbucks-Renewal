package com.team114.starbucks.domain.option.dto.out;

import com.team114.starbucks.domain.option.entity.Option;
import com.team114.starbucks.domain.option.vo.out.OptionResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OptionResponseDto {

    private final Integer optionId;
    private final String productUuid;
    private final Long colorId;
    private final String colorName;
    private final Long sizeId;
    private final String sizeName;
    private final Integer stock;
    private final Integer optionPrice;
    private final Integer discountRate;

    @Builder
    public OptionResponseDto(
            Integer optionId,
            String productUuid,
            Long colorId,
            String colorName,
            Long sizeId,
            String sizeName,
            Integer stock,
            Integer optionPrice,
            Integer discountRate
    ) {
        this.optionId = optionId;
        this.productUuid = productUuid;
        this.colorId = colorId;
        this.colorName = colorName;
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.stock = stock;
        this.optionPrice = optionPrice;
        this.discountRate = discountRate;
    }

    public OptionResponseVo toVo() {
        return OptionResponseVo.builder()
                .optionId(optionId)
                .productUuid(productUuid)
                .colorId(colorId)
                .colorName(colorName)
                .sizeId(sizeId)
                .sizeName(sizeName)
                .stock(stock)
                .optionPrice(optionPrice)
                .discountRate(discountRate)
                .build();
    }

    public static OptionResponseDto fromEntity(Option option) {

        return OptionResponseDto.builder()
                .optionId(option.getOptionId())
                .productUuid(option.getProductUuid())
                .colorId(option.getColor().getColorId())
                .colorName(option.getColor().getColorName())
                .sizeId(option.getSize().getSizeId())
                .sizeName(option.getSize().getSizeName())
                .stock(option.getStock())
                .optionPrice(option.getOptionPrice())
                .discountRate(option.getDiscountRate())
                .build();

    }
}