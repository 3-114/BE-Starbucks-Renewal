package com.team114.starbucks.domain.crawling;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class CrawledProductDto {

    @JsonProperty("카테고리")
    private List<String> category; // [대분류, 소분류]

    @JsonProperty("제품명")
    private String productName;

    @JsonProperty("정가")
    private Integer productPrice;

    @JsonProperty("할인가")
    private Long optionPrice;

    @JsonProperty("상세정보HTML")
    private String productDescription;

    @JsonProperty("썸네일이미지")
    private List<ThumbnailDto> thumbnails;

    @Data
    public static class ThumbnailDto {

        @JsonProperty("url")
        private String thumbnailUrl;

        @JsonProperty("alt")
        private String thumbnailIndex;
    }
}