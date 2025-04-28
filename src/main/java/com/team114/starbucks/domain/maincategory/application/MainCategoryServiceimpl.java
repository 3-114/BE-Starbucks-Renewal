package com.team114.starbucks.domain.maincategory.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.maincategory.dto.in.CreateMainCategoryReqDto;
import com.team114.starbucks.domain.maincategory.dto.in.UpdateMainCategoryReqDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetAllMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetNameAndImageResDto;
import com.team114.starbucks.domain.maincategory.dto.out.GetMainCategoryResDto;
import com.team114.starbucks.domain.maincategory.entity.MainCategory;
import com.team114.starbucks.domain.maincategory.infrastructure.MainCategoryRepository;
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
    public GetMainCategoryResDto getOneMainCategory(String mainCategoryUuid) {
        MainCategory mainCategory = mainCategoryRepository.findByMainCategoryUuid(mainCategoryUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );
        return GetMainCategoryResDto.from(mainCategory);
    }

    @Transactional
    @Override
    public void saveMainCategory(CreateMainCategoryReqDto createMainCategoryReqDto) {
        try {
            mainCategoryRepository.save(createMainCategoryReqDto.toEntity(UUID.randomUUID().toString()));

        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAILED_TO_FIND);
        }
    }

    @Transactional
    @Override
    public void updateMainCategory(String mainCategoryUuid, UpdateMainCategoryReqDto updateMainCategoryReqDto) {
        MainCategory mainCategory = mainCategoryRepository.findByMainCategoryUuid(mainCategoryUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );

        MainCategory updatedMainCategory = MainCategory.builder()
                .id(mainCategory.getId())
                .mainCategoryUuid(mainCategory.getMainCategoryUuid())
                .mainCategoryName(updateMainCategoryReqDto.getMainCategoryName() == null ? mainCategory.getMainCategoryName() : updateMainCategoryReqDto.getMainCategoryName())
                .build();

        mainCategoryRepository.save(updatedMainCategory);
    }

    @Transactional
    @Override
    public void deleteMainCategory(String mainCategoryUuid) {
        mainCategoryRepository.deleteByMainCategoryUuid(mainCategoryUuid).orElseThrow(
                () -> new BaseException(BaseResponseStatus.FAILED_TO_FIND)
        );
    }

    @Override
    public List<GetNameAndImageResDto> getNameAndImage() {
        List<MainCategory> nameAndImageList = mainCategoryRepository.findAll();
        List<GetNameAndImageResDto> nameAndImageResDtoList = new ArrayList<>();

        for (MainCategory mainCategory : nameAndImageList) {
            GetNameAndImageResDto dto = GetNameAndImageResDto.from(mainCategory);
            nameAndImageResDtoList.add(dto);
        }
        return nameAndImageResDtoList;
    }

}