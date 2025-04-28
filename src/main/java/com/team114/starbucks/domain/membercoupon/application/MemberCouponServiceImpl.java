package com.team114.starbucks.domain.membercoupon.application;

import com.team114.starbucks.common.exception.BaseException;
import com.team114.starbucks.common.response.BaseResponseStatus;
import com.team114.starbucks.domain.coupon.entity.Coupon;
import com.team114.starbucks.domain.membercoupon.dto.out.GetAllMyCouponResDto;
import com.team114.starbucks.domain.membercoupon.enums.CouponStatus;
import com.team114.starbucks.domain.coupon.infrastructure.CouponRepository;
import com.team114.starbucks.domain.membercoupon.dto.in.CreateIssueCouponReqDto;
import com.team114.starbucks.domain.membercoupon.dto.in.ConsumeCouponReqDto;
import com.team114.starbucks.domain.membercoupon.entity.MemberCoupon;
import com.team114.starbucks.domain.membercoupon.enums.CouponViewFilter;
import com.team114.starbucks.domain.membercoupon.infrastructure.MemberCouponRepository;
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

    @Transactional
    @Override
    public void issueCoupon(String memberUuid, CreateIssueCouponReqDto createIssueCouponReqDto) {

        Coupon coupon = couponRepository.findByCouponUuid(createIssueCouponReqDto.getCouponUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        LocalDateTime issuedAt = LocalDateTime.now();

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

        userCouponRepository.save(memberCoupon);
    }

    @Transactional
    @Override
    public void consumeCoupon(String memberUuid, ConsumeCouponReqDto useCouponReqDto) {

        Coupon coupon = couponRepository.findByCouponUuid(useCouponReqDto.getCouponUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

        MemberCoupon memberCoupon = userCouponRepository.findByMemberUuidAndCoupon_CouponUuid(memberUuid, useCouponReqDto.getCouponUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_FIND));

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

        userCouponRepository.save(usedMemberCoupon);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<GetAllMyCouponResDto> getMyCoupons(
            String memberUuid,
            CouponViewFilter status,
            Pageable pageable
    ) {
        switch (status) {
            // [1] 내 쿠폰 전체 조회
            case MY_COUPON_ALL -> {
                return memberCouponRepository.findAllByMemberUuid(
                        memberUuid,
                        pageable
                ).map(GetAllMyCouponResDto::from);
            }
            // [2] 사용 가능한 쿠폰 조회
            case MY_COUPON_AVAILABLE -> {
                return memberCouponRepository.findByMemberUuidAndCouponStatus(
                        memberUuid,
                        CouponStatus.COUPON_AVAILABLE,
                        pageable
                ).map(GetAllMyCouponResDto::from);
            }
            // [3] 사용 완료된 쿠폰 조회
            case MY_COUPON_USED -> {
                return memberCouponRepository.findByMemberUuidAndCouponStatus(
                        memberUuid,
                        CouponStatus.COUPON_USED,
                        pageable
                ).map(GetAllMyCouponResDto::from);
            }
            // [4] 기간 만료된 쿠폰 조회
            case MY_COUPON_EXPIRED -> {
                return memberCouponRepository.findByMemberUuidAndCouponStatus(
                        memberUuid,
                        CouponStatus.COUPON_EXPIRED,
                        pageable
                ).map(GetAllMyCouponResDto::from);
            }
            // [5] 사용 불가능한 쿠폰 조회
            case MY_COUPON_NOT_AVAILABLE -> {
                return memberCouponRepository.findByMemberUuidAndCouponStatusIn(
                        memberUuid,
                        List.of(CouponStatus.COUPON_USED, CouponStatus.COUPON_EXPIRED),
                        pageable
                ).map(GetAllMyCouponResDto::from);
            }
            // [6] 유효하지 않은 ENUM 값이 넘어올 때 예외 처리
            default -> throw new BaseException(BaseResponseStatus.FAILED_TO_FIND);
        }
    }

}