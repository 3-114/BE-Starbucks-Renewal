package com.team114.starbucks.domain.delivery.vo.out;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class AliasVo {
    private final String alias;

    public AliasVo(String alias) {
        this.alias = alias;
    }
}
