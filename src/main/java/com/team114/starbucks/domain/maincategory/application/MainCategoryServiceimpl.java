package com.team114.starbucks.domain.maincategory.application;

import com.team114.starbucks.domain.maincategory.dto.out.GetAllMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.entity.MainCategory;
import com.team114.starbucks.domain.maincategory.infrastructure.MainCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainCategoryServiceimpl implements MainCategoryService {

    private final MainCategoryRepository mainCategoryRepository;

    // 메인 카테고리 전체 조회
    @Override
    public List<GetAllMainCategoryResDto> getAllMainCategory() {

        List<MainCategory> mainCategoryList = mainCategoryRepository.findAll();
        List<GetAllMainCategoryResDto> mainCategoryResDtoList = new ArrayList<>();

        for (MainCategory mainCategory : mainCategoryList) {
            GetAllMainCategoryResDto dto = GetAllMainCategoryResDto.from(mainCategory);
            mainCategoryResDtoList.add(dto);
        }

        return mainCategoryResDtoList;
    }
}
