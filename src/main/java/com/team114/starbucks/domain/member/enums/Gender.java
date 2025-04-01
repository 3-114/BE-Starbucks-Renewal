package com.team114.starbucks.domain.member.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {

    GENDER_MALE("남성"),        // 남성
    GENDER_FEMALE("여성")       // 여성
    ;
    private final String gender;
    @JsonValue
    public String getGender() {
        return gender;
    }
    @JsonCreator
    public static Gender fromString(String value) {
        for (Gender gender : Gender.values()) {
            if (gender.gender.equals(value)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
