package com.team114.starbucks.domain.delivery.presentation;

import com.team114.starbucks.common.response.BaseResponseEntity;
import com.team114.starbucks.domain.delivery.application.DeliveryService;
import com.team114.starbucks.domain.delivery.dto.in.GetCartDeliveryReDto;
import com.team114.starbucks.domain.delivery.dto.in.CreateDeliveryReqDto;
import com.team114.starbucks.domain.delivery.dto.in.GetSelectedDeliveryReqDto;
import com.team114.starbucks.domain.delivery.dto.in.UpdateDeliveryReqDto;
import com.team114.starbucks.domain.delivery.dto.out.GetAllDeliveryResDto;
import com.team114.starbucks.domain.delivery.dto.out.GetDeliveryUuidResDto;
import com.team114.starbucks.domain.delivery.vo.in.CreateDeliveryReqVo;
import com.team114.starbucks.domain.delivery.vo.in.UpdateSelectedDeliveryReqVo;
import com.team114.starbucks.domain.delivery.vo.in.UpdateDeliveryReqVo;
import com.team114.starbucks.domain.delivery.vo.out.CreateDeliveryResVo;
import com.team114.starbucks.domain.delivery.vo.out.GetSelectedDeliveryResVo;
import com.team114.starbucks.domain.delivery.vo.out.GetCartDeliveryResVo;
import com.team114.starbucks.domain.delivery.vo.out.GetAllDeliveryUuidResVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    /**
     * 1. 배송지 생성
     * 2. 배송지 수정
     * 3. 배송지 삭제
     * 4. 마이페이지 배송지 목록 조회
     * 5. 장바구니에서 배송지 UUID 리스트 조회
     * 6. 장바구니의 캐러셀에서 갱신될 배송지 단건 수정
     * 7. 장바구니 캐러셀 단건 조회
     * 8. 배송지 단건 조회 (주문용)
     */

    /**
     * 1. 배송지 생성
     *
     * @param createDeliveryReqVo 배송지 생성 데이터
     * @param authentication          회원 UUID
     * @return {@link BaseResponseEntity} 배송지 생성 결과
     */
    @Operation(summary = "배송지 등록", description = "배송지를 등록합니다.", tags = {"delivery"})
    @PostMapping
    public BaseResponseEntity<CreateDeliveryResVo> createDelivery(
            @RequestBody CreateDeliveryReqVo createDeliveryReqVo,
            Authentication authentication
    ) {
        CreateDeliveryResVo result = deliveryService.saveDelivery(
                CreateDeliveryReqDto.from(createDeliveryReqVo, authentication.getName())).toVo();
        return new BaseResponseEntity<>("배송지가 등록되었습니다.", result);
    }

    /**
     * 2. 배송지 수정
     *
     * @param deliveryUuid            배송지 UUID
     * @param authentication          회원 UUID
     * @param updateDeliveryReqVo 배송지 수정 데이터
     * @return {@link BaseResponseEntity} 배송지 수정 결과
     */
    @Operation(summary = "배송지 수정", description = "기존 배송지를 비활성화하고 새 배송지를 생성합니다.", tags = {"delivery"})
    @PutMapping("/{deliveryUuid}")
    public BaseResponseEntity<CreateDeliveryResVo> updateDelivery(
            @PathVariable String deliveryUuid,
            Authentication authentication,
            @RequestBody UpdateDeliveryReqVo updateDeliveryReqVo) {

        deliveryService.updateDelivery(UpdateDeliveryReqDto.from(updateDeliveryReqVo, authentication.getName(), deliveryUuid));

        return new BaseResponseEntity<>("배송지가 수정되었습니다.");
    }

    /**
     * 3. 배송지 삭제
     *
     * @param deliveryUuid 배송지 UUID
     * @return {@link BaseResponseEntity} 배송지 삭제 결과
     */
    @Operation(summary = "배송지 삭제", description = "배송지를 삭제합니다.", tags = {"delivery"})
    @DeleteMapping("/{deliveryUuid}")
    public BaseResponseEntity<Void> deleteDelivery(
            @PathVariable String deliveryUuid
    ) {
        deliveryService.deleteDelivery(deliveryUuid);
        return new BaseResponseEntity<>("배송지가 삭제되었습니다.", null);
    }

    /**
     * 4. 마이페이지 배송지 목록 조회
     *
     * @param authentication 회원 UUID
     * @return {@link BaseResponseEntity} 배송지 목록 조회 결과
     */
    @Operation(summary = "배송지 목록 조회", description = "회원의 전체 배송지를 조회합니다.", tags = {"delivery"})
    @GetMapping("/all")
    public BaseResponseEntity<List<CreateDeliveryResVo>> getAllDeliveries(
            Authentication authentication
    ) {
        List<CreateDeliveryResVo> result = deliveryService.getDeliveriesByMemberUuid(authentication.getName())
                .stream().map(GetAllDeliveryResDto::toVo).toList();

        return new BaseResponseEntity<>("배송지 목록 조회 성공", result);
    }

    /**
     * 5. 장바구니에서 배송지 UUID 리스트 조회
     *
     * @param authentication 회원 UUID
     * @return {@link BaseResponseEntity} 배송지 생성 결과
     */
    @Operation(summary = "배송지 UUID 목록 조회", description = "회원의 배송지 UUID 목록만 조회합니다.", tags = {"delivery"})
    @GetMapping("/cart/uuids")
    public BaseResponseEntity<List<GetAllDeliveryUuidResVo>> getCartDeliveryUuid(
            Authentication authentication
    ) {
        List<GetAllDeliveryUuidResVo> result = deliveryService.getDeliveryUuidsByMemberUuid(authentication.getName())
                .stream().map(GetDeliveryUuidResDto::toVo).toList();

        return new BaseResponseEntity<>("장바구니의 배송지 UUID 리스트 조회 성공", result);
    }

    /**
     * 6. 장바구니의 캐러셀에서 갱신될 배송지 단건 조회
     *
     * @param authentication            회원 UUID
     * @param updateSelectedDeliveryReqVo 배송지 UUID
     * @return {@link BaseResponseEntity} 배송지 생성 결과
     */
    @Operation(summary = "장바구니 배송지 변경", description = "장바구니의 캐러셀 배송지 변경", tags = {"delivery"})
    @PutMapping("/cart/update-address")
    public BaseResponseEntity<GetSelectedDeliveryResVo> updateSelectedDelivery(
            Authentication authentication,
            @RequestBody UpdateSelectedDeliveryReqVo updateSelectedDeliveryReqVo
    ) {
        GetSelectedDeliveryResVo result = deliveryService
                .updateSelectedDelivery(GetSelectedDeliveryReqDto.from(updateSelectedDeliveryReqVo, authentication.getName())).toVo();

        return new BaseResponseEntity<>("선택된 배송지가 변경되었습니다.", result);
    }

    /**
     * 7. 장바구니 캐러셀 단건 조회
     *
     * @param authentication 회원 UUID
     * @param deliveryUuid   배송지 UUID
     * @return {@link BaseResponseEntity} 배송지 생성 결과
     */
    @Operation(summary = "장바구니 배송지 목록 조회", description = "장바구니 배송지를 단건 조회합니다.", tags = {"delivery"})
    @GetMapping("/cart/get-address/{deliveryUuid}")
    public BaseResponseEntity<GetCartDeliveryResVo> getSelectedDelivery(
            Authentication authentication,
            @PathVariable String deliveryUuid
    ) {
        GetCartDeliveryResVo result = deliveryService
                .getCartDeliveryByUuid(GetCartDeliveryReDto.from(deliveryUuid, authentication.getName())).toVo();

        return new BaseResponseEntity<>("캐러셀 배송지 단건 조회에 성공했습니다.", result);
    }

    /**
     * 8. 배송지 단건 조회 (주문용)
     *
     * @param authentication 회원 UUID
     * @return {@link BaseResponseEntity} 배송지 생성 결과
     */
    @Operation(summary = "주문용 배송지 조회", description = "장바구니에서 선택된 배송지 조회", tags = {"delivery"})
    @GetMapping("/order/selected-address")
    public BaseResponseEntity<GetSelectedDeliveryResVo> getSelectedDelivery(
            Authentication authentication
    ) {
        GetSelectedDeliveryResVo result = deliveryService
                .getSelectedDeliveryByMemberUuid(authentication.getName())
                .toVo();

        return new BaseResponseEntity<>("선택된 배송지 조회 성공", result);
    }
}