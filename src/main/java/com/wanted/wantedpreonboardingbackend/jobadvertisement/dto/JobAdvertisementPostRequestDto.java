package com.wanted.wantedpreonboardingbackend.jobadvertisement.dto;

import lombok.Getter;

@Getter
public class JobAdvertisementPostRequestDto {
    private Long companyId;
    private String position;
    private int compensation;
    private String description;
    private String skill;
}
