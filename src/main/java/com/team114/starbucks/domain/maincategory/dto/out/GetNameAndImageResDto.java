package com.team114.starbucks.domain.maincategory.dto.out;

import com.team114.starbucks.domain.maincategory.entity.MainCategory;
import com.team114.starbucks.domain.maincategory.vo.out.GetNameAndImageResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetNameAndImageResDto {

    private String mainCategoryUuid;
    private String mainCategoryName;
    private String mainCategoryImage;

    @Builder
    public GetNameAndImageResDto(String mainCategoryUuid, String mainCategoryName, String mainCategoryImage) {
        this.mainCategoryUuid = mainCategoryUuid;
        this.mainCategoryName = mainCategoryName;
        this.mainCategoryImage = mainCategoryImage;
    }

    public static GetNameAndImageResDto from(MainCategory mainCategory) {
        return GetNameAndImageResDto.builder()
                .mainCategoryUuid(mainCategory.getMainCategoryUuid())
                .mainCategoryName(mainCategory.getMainCategoryName())
                .mainCategoryImage(mainCategory.getMainCategoryImage())
                .build();
    }

    public GetNameAndImageResVo toVo() {
        return GetNameAndImageResVo.builder()
                .mainCategoryUuid(mainCategoryUuid)
                .mainCategoryName(mainCategoryName)
                .mainCategoryImage(mainCategoryImage)
                .build();
    }

}
