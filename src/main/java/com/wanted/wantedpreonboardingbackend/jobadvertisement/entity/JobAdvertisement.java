package com.wanted.wantedpreonboardingbackend.jobadvertisement.entity;

import com.wanted.wantedpreonboardingbackend.company.entity.Company;
import com.wanted.wantedpreonboardingbackend.jobadvertisement.dto.JobAdvertisementPostRequestDto;
import com.wanted.wantedpreonboardingbackend.jobadvertisement.dto.JobAdvertisementPutRequestDto;
import com.wanted.wantedpreonboardingbackend.userApplication.entity.UserApplication;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

// 채용공고
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "job_advertisement")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "compensation", nullable = false)
    private int compensation;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "skill", nullable = false)
    private String skill;

    //연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "jobAdvertisement", orphanRemoval = true)
    private List<UserApplication> userApplications = new ArrayList<>();

    public JobAdvertisement(JobAdvertisementPostRequestDto requestDto, Company company) {
        this.position = requestDto.getPosition();
        this.compensation = requestDto.getCompensation();
        this.description = requestDto.getDescription();
        this.skill = requestDto.getSkill();
        this.company = company;
    }

    public void modify(JobAdvertisementPutRequestDto requestDto) {
        this.position = requestDto.getPosition();
        this.compensation = requestDto.getCompensation();
        this.description = requestDto.getDescription();
        this.skill = requestDto.getSkill();
    }
}
