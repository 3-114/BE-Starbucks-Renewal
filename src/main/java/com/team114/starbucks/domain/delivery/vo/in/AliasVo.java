package com.team114.starbucks.domain.delivery.vo.in;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class AliasVo {

    private final String alias;

    public AliasVo(String alias) {
        if (alias != null && alias.length() > 20) {
            throw new IllegalArgumentException("주소 별칭은 20자 이내여야 합니다.");
        }
        this.alias = alias;
    }
}