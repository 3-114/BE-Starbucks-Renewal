package com.team114.starbucks.domain.oauth2.dto;



public interface OAuth2Response {

    String getProvider();

    String getProviderId();

    String getEmail();

    String getName();
}
