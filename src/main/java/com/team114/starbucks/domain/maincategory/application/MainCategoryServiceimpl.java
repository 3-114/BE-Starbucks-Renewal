package com.team114.starbucks.domain.maincategory.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.maincategory.dto.in.CreateMainCategoryReqDto;
import com.team114.starbucks.domain.maincategory.dto.in.UpdateMainCategoryReqDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetAllMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetOneMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.entity.MainCategory;
import com.team114.starbucks.domain.maincategory.infrastructure.MainCategoryRepository;
import com.team114.starbucks.domain.maincategory.vo.out.CreateMainCategoryResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Override
    public GetOneMainCategoryResDto getOneMainCategory(String mainCategoryUuid) {
        MainCategory mainCategory = mainCategoryRepository.findByMainCategoryUuid(mainCategoryUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );
        // entity -> dto
        return GetOneMainCategoryResDto.from(mainCategory);
    }

    @Transactional
    @Override
    public CreateMainCategoryResDto saveMainCategory(CreateMainCategoryReqDto createMainCategoryReqDto) {
        try {
            MainCategory mainCategory = createMainCategoryReqDto.toEntity(UUID.randomUUID().toString());
            MainCategory savedMainCategory = mainCategoryRepository.save(mainCategory);

            return CreateMainCategoryResDto.from(savedMainCategory);
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_FIND);
        }
    }

    @Transactional
    @Override
    public Void updateMainCategory(String mainCategoryUuid, UpdateMainCategoryReqDto updateMainCategoryReqDto) {
        MainCategory mainCategory = mainCategoryRepository.findByMainCategoryUuid(mainCategoryUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        MainCategory updatedMainCategory = MainCategory.builder()
                .id(mainCategory.getId())
                .mainCategoryUuid(mainCategory.getMainCategoryUuid())
                .mainCategoryName(updateMainCategoryReqDto.getMainCategoryName() == null ? mainCategory.getMainCategoryName() : updateMainCategoryReqDto.getMainCategoryName())
                .build();

        mainCategoryRepository.save(updatedMainCategory);

        return null;
    }


    //동짱

    @Transactional
    @Override
    public Void deleteMainCategory(String mainCategoryUuid) {
        mainCategoryRepository.deleteByMainCategoryUuid(mainCategoryUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        return null;
    }


}
