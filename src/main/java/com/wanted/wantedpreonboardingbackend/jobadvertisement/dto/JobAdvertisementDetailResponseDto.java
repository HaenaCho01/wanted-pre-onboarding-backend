package com.wanted.wantedpreonboardingbackend.jobadvertisement.dto;

import com.wanted.wantedpreonboardingbackend.jobadvertisement.entity.JobAdvertisement;
import lombok.Getter;

import java.util.List;

@Getter
public class JobAdvertisementDetailResponseDto {
    private Long jobAdvertisementId;
    private String companyName;
    private String country;
    private String location;
    private String position;
    private int compensation;
    private String skill;
    private String description;
    private List<Long> companyOtherJobAdvertisements;

    public JobAdvertisementDetailResponseDto(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementId = jobAdvertisement.getId();
        this.companyName = jobAdvertisement.getCompany().getName();
        this.country = jobAdvertisement.getCompany().getCountry();
        this.location = jobAdvertisement.getCompany().getLocation();
        this.position = jobAdvertisement.getPosition();
        this.compensation = jobAdvertisement.getCompensation();
        this.skill = jobAdvertisement.getSkill();
        this.description = jobAdvertisement.getDescription();
        this.companyOtherJobAdvertisements = jobAdvertisement.getCompany().
                getJobAdvertisements().stream()
                .filter(otherAdvertisement -> !otherAdvertisement.getId().equals(jobAdvertisement.getId()))
                .map(JobAdvertisement::getId).toList();
    }
}
