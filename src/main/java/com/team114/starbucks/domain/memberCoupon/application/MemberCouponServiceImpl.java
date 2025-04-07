package com.team114.starbucks.domain.memberCoupon.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.coupon.entity.Coupon;
import com.team114.starbucks.domain.memberCoupon.dto.out.MyCouponResDto;
import com.team114.starbucks.domain.memberCoupon.enums.CouponStatus;
import com.team114.starbucks.domain.coupon.infrastructure.CouponRepository;
import com.team114.starbucks.domain.memberCoupon.dto.in.IssueCouponReqDto;
import com.team114.starbucks.domain.memberCoupon.dto.in.ConsumeCouponReqDto;
import com.team114.starbucks.domain.memberCoupon.entity.MemberCoupon;
import com.team114.starbucks.domain.memberCoupon.enums.CouponViewFilter;
import com.team114.starbucks.domain.memberCoupon.infrastructure.MemberCouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCouponServiceImpl implements MemberCouponService {

    private final MemberCouponRepository userCouponRepository;
    private final CouponRepository couponRepository;
    private final MemberCouponRepository memberCouponRepository;

    /**
     * /api/v1/my-coupons
     * 1. 쿠폰 받기 (쿠폰 발행하기)
     * 2. 쿠폰 사용하기
     * 3. 내 쿠폰 조회
     */

    /**
     * 1. 쿠폰 받기
     * @param memberUuid, issueCouponReqDto
     * @return
     * @throws
     */
    @Transactional
    @Override
    public Void issueCoupon(String memberUuid, IssueCouponReqDto issueCouponReqDto) {

        // [1] couponUuid 로 coupon 조회
        Coupon coupon = couponRepository.findByCouponUuid(issueCouponReqDto.getCouponUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        // [2] 발급 시간과 만료 시간의 기준 동일시
        LocalDateTime issuedAt = LocalDateTime.now();

        // [3] memberCoupon 객체 생성
        MemberCoupon memberCoupon = MemberCoupon.builder()
                .coupon(coupon)
                .memberUuid(memberUuid)
                .couponStatus(CouponStatus.COUPON_AVAILABLE)
                .issued(true)
                .issuedAt(issuedAt)
                .expiredAt(issuedAt.plusDays(coupon.getValidDays()))
                .used(false)
                .usedAt(null)
                .build();

        // [4] userCoupon 저장
        userCouponRepository.save(memberCoupon);

        return null;
    }

    /**
     * 2. 쿠폰 사용하기
     * @param memberUuid, useCouponReqDto
     * @return
     * @throws
     */
    @Transactional
    @Override
    public Void consumeCoupon(String memberUuid, ConsumeCouponReqDto useCouponReqDto) {

        // TODO : 유효성 검사 - 본인 쿠폰인지 확인 (memberUuid 사용)
        // TODO : 유효성 검사 - 쿠폰 만료 기간이 지났는지 확인 (coupon 사용)

        // [1] couponUuid 로 coupon 조회
        Coupon coupon = couponRepository.findByCouponUuid(useCouponReqDto.getCouponUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        // [2] memberUuid 와 couponUuid 로 userCoupon 조회
        MemberCoupon memberCoupon = userCouponRepository.findByMemberUuidAndCoupon_CouponUuid(memberUuid, useCouponReqDto.getCouponUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        // [3] UserCoupon 새 객체 생성
        MemberCoupon usedMemberCoupon = MemberCoupon.builder()
                .id(memberCoupon.getId())
                .coupon(coupon)
                .memberUuid(memberUuid)
                .couponStatus(CouponStatus.COUPON_USED)
                .issued(memberCoupon.getIssued())
                .issuedAt(memberCoupon.getIssuedAt())
                .expiredAt(memberCoupon.getExpiredAt())
                .used(true)
                .usedAt(LocalDateTime.now())
                .build();

        // [4] userCoupon 저장
        userCouponRepository.save(usedMemberCoupon);

        return null;
    }

    /**
     * 3. 내 쿠폰 조회
     * @param memberUuid, status, pageable
     * @return Page<MyCouponResDto>
     * @throws
     */
    @Transactional(readOnly = true)
    @Override
    public Page<MyCouponResDto> getMyCoupons(
            String memberUuid,
            CouponViewFilter status,
            Pageable pageable
    ) {
        // param 에 따른 switch 문 사용 -> stream, method 참조 사용
        switch(status) {
            // [1] 내 쿠폰 전체 조회
            case MY_COUPON_ALL -> {
                return memberCouponRepository.findAllByMemberUuid(
                        memberUuid,
                        pageable
                ).map(MyCouponResDto::from);
            }
            // [2] 사용 가능한 쿠폰 조회
            case MY_COUPON_AVAILABLE -> {
                return memberCouponRepository.findByMemberUuidAndCouponStatus(
                        memberUuid,
                        CouponStatus.COUPON_AVAILABLE,
                        pageable
                ).map(MyCouponResDto::from);
            }
            // [3] 사용 완료된 쿠폰 조회
            case MY_COUPON_USED -> {
                return memberCouponRepository.findByMemberUuidAndCouponStatus(
                        memberUuid,
                        CouponStatus.COUPON_USED,
                        pageable
                ).map(MyCouponResDto::from);
            }
            // [4] 기간 만료된 쿠폰 조회
            case MY_COUPON_EXPIRED -> {
                return memberCouponRepository.findByMemberUuidAndCouponStatus(
                        memberUuid,
                        CouponStatus.COUPON_EXPIRED,
                        pageable
                ).map(MyCouponResDto::from);
            }
            // [5] 사용 불가능한 쿠폰 조회
            case MY_COUPON_NOT_AVAILABLE -> {
                return memberCouponRepository.findByMemberUuidAndCouponStatusIn(
                        memberUuid,
                        List.of(CouponStatus.COUPON_USED, CouponStatus.COUPON_EXPIRED),
                        pageable
                ).map(MyCouponResDto::from);
            }
            // [6] 유효하지 않은 ENUM 값이 넘어올 때 예외 처리
            default -> throw new BaseException(BaseResponseStatus.FAILED_TO_FIND);
        }
    }
}
