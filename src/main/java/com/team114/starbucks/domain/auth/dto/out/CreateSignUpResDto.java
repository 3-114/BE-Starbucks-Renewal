package com.team114.starbucks.domain.auth.dto.out;

import com.team114.starbucks.domain.member.entity.Member;
import com.team114.starbucks.domain.auth.vo.out.CreateSignUpResVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateSignUpResDto {

    private String nickname;

    @Builder
    public CreateSignUpResDto(String nickname) {
        this.nickname = nickname;
    }

    public static CreateSignUpResDto from(Member member) {

        return CreateSignUpResDto.builder()
                .nickname(member.getNickname())
                .build();
    }

    public CreateSignUpResVo toVo() {

        return CreateSignUpResVo.builder()
                .nickname(nickname)
                .build();
    }
}