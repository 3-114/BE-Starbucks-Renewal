package com.team114.starbucks.domain.delivery.vo.in;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class RecipientVo {

    private String recipient;

    public RecipientVo(String recipient) {
        if (recipient == null || recipient.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 필수입니다.");
        }

        if (recipient.length() > 20) {
            throw new IllegalArgumentException("이름은 20자 이하로 입력해주세요.");
        }

        this.recipient = recipient;
    }
}