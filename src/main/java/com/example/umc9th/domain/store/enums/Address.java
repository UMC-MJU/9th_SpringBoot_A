package com.example.umc9th.domain.store.enums;

public enum Address {
    GANGNAM("강남구"),
    JONGNO("종로구"),
    SEOCHO("서초구"),
    EUNPYEONG("은평구");

    private final String koreanName;

    Address(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }
}
