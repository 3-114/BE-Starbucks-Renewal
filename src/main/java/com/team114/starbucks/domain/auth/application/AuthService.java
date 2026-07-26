package com.team114.starbucks.domain.auth.application;

import com.team114.starbucks.domain.auth.dto.in.GetSignInReqDto;
import com.team114.starbucks.domain.auth.dto.in.CreateSignUpReqDto;
import com.team114.starbucks.domain.auth.dto.out.GetSignInResDto;
import com.team114.starbucks.domain.auth.dto.out.CreateSignUpResDto;

public interface AuthService {

    CreateSignUpResDto signUp(CreateSignUpReqDto createSignUpReqDto);

    GetSignInResDto signIn(GetSignInReqDto getSignInReqDto);

}