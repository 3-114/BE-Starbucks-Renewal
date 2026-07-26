package com.team114.starbucks.domain.maincategory.dto.in;

import com.team114.starbucks.domain.maincategory.vo.in.UpdateMainCategoryReqVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateMainCategoryReqDto {

    private String mainCategoryName;

    @Builder
    public UpdateMainCategoryReqDto(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

    public static UpdateMainCategoryReqDto from(UpdateMainCategoryReqVo updateMainCategoryReqVo) {
        return UpdateMainCategoryReqDto.builder()
                .mainCategoryName(updateMainCategoryReqVo.getMainCategoryName())
                .build();
    }

}