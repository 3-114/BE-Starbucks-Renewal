package com.team114.starbucks.domain.option.dto.in;

import com.team114.starbucks.domain.color.entity.Color;
import com.team114.starbucks.domain.option.entity.Option;
import com.team114.starbucks.domain.option.vo.in.CreateOptionReqVo;
import com.team114.starbucks.domain.size.entity.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateOptionReqDto {

    private String productUuid;
    private Long colorId;
    private Long sizeId;
    private Integer stock;
    private Long optionPrice;
    private Integer discountRate;

    @Builder
    public CreateOptionReqDto(
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

    public static CreateOptionReqDto from(
            CreateOptionReqVo createOptionReqVo
    ) {
        return CreateOptionReqDto.builder()
                .productUuid(createOptionReqVo.getProductUuid())
                .colorId(createOptionReqVo.getColorId())
                .sizeId(createOptionReqVo.getSizeId())
                .stock(createOptionReqVo.getStock())
                .optionPrice(createOptionReqVo.getOptionPrice())
                .discountRate(createOptionReqVo.getDiscountRate())
                .build();
    }

    public Option toEntity(Color color, Size size) {
        return Option.builder()
                .productUuid(productUuid)
                .color(color)
                .size(size)
                .stock(stock)
                .optionPrice(optionPrice)
                .discountRate(discountRate)
                .build();
    }

}
