package com.team114.starbucks.domain.maincategory.dto.in;

import com.team114.starbucks.domain.maincategory.entity.MainCategory;
import com.team114.starbucks.domain.maincategory.vo.in.CreateMainCategoryReqVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateMainCategoryReqDto {

    private String mainCategoryUuid;
    private String mainCategoryName;

    @Builder
    public CreateMainCategoryReqDto(String mainCategoryUuid, String mainCategoryName) {
        this.mainCategoryUuid = mainCategoryUuid;
        this.mainCategoryName = mainCategoryName;
    }

    public static CreateMainCategoryReqDto from(CreateMainCategoryReqVo createMainCategoryReqVo) {
        return CreateMainCategoryReqDto.builder()
                .mainCategoryUuid(createMainCategoryReqVo.getMainCategoryUuid())
                .mainCategoryName(createMainCategoryReqVo.getMainCategoryName())
                .build();
    }

    public MainCategory toEntity(String mainCategoryUuid) {
        return MainCategory.builder()
                .mainCategoryUuid(mainCategoryUuid)
                .mainCategoryName(mainCategoryName)
                .build();
    }
}
