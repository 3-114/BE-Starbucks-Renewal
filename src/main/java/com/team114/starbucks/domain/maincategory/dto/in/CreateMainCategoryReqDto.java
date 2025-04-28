package com.team114.starbucks.domain.maincategory.dto.in;

import com.team114.starbucks.domain.maincategory.entity.MainCategory;
import com.team114.starbucks.domain.maincategory.vo.in.CreateMainCategoryReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateMainCategoryReqDto {

    private String mainCategoryName;
    private String mainCategoryImage;

    @Builder
    public CreateMainCategoryReqDto(String mainCategoryName, String mainCategoryImage) {
        this.mainCategoryName = mainCategoryName;
        this.mainCategoryImage = mainCategoryImage;
    }

    public static CreateMainCategoryReqDto from(CreateMainCategoryReqVo createMainCategoryReqVo) {
        return CreateMainCategoryReqDto.builder()
                .mainCategoryName(createMainCategoryReqVo.getMainCategoryName())
                .mainCategoryImage(createMainCategoryReqVo.getMainCategoryImage())
                .build();
    }

    public MainCategory toEntity(String mainCategoryUuid) {
        return MainCategory.builder()
                .mainCategoryUuid(mainCategoryUuid)
                .mainCategoryName(mainCategoryName)
                .mainCategoryImage(mainCategoryImage)
                .build();
    }

}