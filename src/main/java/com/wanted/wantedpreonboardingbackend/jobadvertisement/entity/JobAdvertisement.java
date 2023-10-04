package com.wanted.wantedpreonboardingbackend.jobadvertisement.entity;

import com.wanted.wantedpreonboardingbackend.company.entity.Company;
import com.wanted.wantedpreonboardingbackend.userJobadvertisement.entity.UserJobAdvertisement;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

// 채용공고
@Entity
@Getter
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

    @OneToMany(mappedBy = "job_advertisement", orphanRemoval = true)
    private List<UserJobAdvertisement> userJobAdvertisements = new ArrayList<>();
}
