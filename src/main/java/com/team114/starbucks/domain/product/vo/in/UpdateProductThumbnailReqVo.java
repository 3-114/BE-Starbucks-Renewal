package com.team114.starbucks.domain.product.vo.in;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateProductThumbnailReqVo {

    private String thumbnailUrl;
    private Integer thumbnailIndex;
    private Boolean isThumbnail;
    private String uploadedBy;

    @Builder
    public UpdateProductThumbnailReqVo(
            String thumbnailUrl,
            Integer thumbnailIndex,
            Boolean isThumbnail,
            String uploadedBy
    ) {
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailIndex = thumbnailIndex;
        this.isThumbnail = isThumbnail;
        this.uploadedBy = uploadedBy;
    }

}
