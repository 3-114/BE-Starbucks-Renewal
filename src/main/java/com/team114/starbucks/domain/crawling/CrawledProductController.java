package com.team114.starbucks.domain.crawling;

import com.team114.starbucks.domain.crawling.CrawledProductService;
import com.team114.starbucks.domain.crawling.CrawledProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/crawling")
public class CrawledProductController {

    private final CrawledProductService crawledProductService;

    @PostMapping("/upload")
    public ResponseEntity<String> saveCrawledProducts(
            @RequestBody List<CrawledProductDto> crawledProductDto
    ) {
        crawledProductService.saveCrawledProductsInBatch(crawledProductDto);
        return ResponseEntity.ok("총 " + crawledProductDto.size() + "건 저장 완료");
    }
}