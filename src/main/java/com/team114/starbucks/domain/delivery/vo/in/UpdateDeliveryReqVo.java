package com.team114.starbucks.domain.delivery.vo.in;

import lombok.Getter;

@Getter
public class UpdateDeliveryReqVo {

    private String alias;
    private String recipient;
    private String zoneCode;
    private String mainAddress;
    private String detailAddress;
    private String phoneNumber1;
    private String phoneNumber2;
    private String deliveryMemo;
    private boolean defaultAddress;

}