package com.team114.starbucks.domain.delivery.vo.in;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class NameVo {

    private String name;

    public NameVo(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 필수입니다.");
        }

        if (name.length() > 20) {
            throw new IllegalArgumentException("이름은 20자 이하로 입력해주세요.");
        }

        this.name = name;
    }
}