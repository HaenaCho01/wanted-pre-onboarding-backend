package com.wanted.wantedpreonboardingbackend.jobadvertisement.dto;

import com.wanted.wantedpreonboardingbackend.jobadvertisement.entity.JobAdvertisement;
import lombok.Getter;

@Getter
public class JobAdvertisementResponseDto {
    private Long jobAdvertisementId;
    private String companyName;
    private String country;
    private String location;
    private String position;
    private int compensation;
    private String skill;

    public JobAdvertisementResponseDto(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementId = jobAdvertisement.getId();
        this.companyName = jobAdvertisement.getCompany().getName();
        this.country = jobAdvertisement.getCompany().getCountry();
        this.location = jobAdvertisement.getCompany().getLocation();
        this.position = jobAdvertisement.getPosition();
        this.compensation = jobAdvertisement.getCompensation();
        this.skill = jobAdvertisement.getSkill();
    }
}
