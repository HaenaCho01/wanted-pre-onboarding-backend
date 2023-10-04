package com.wanted.wantedpreonboardingbackend.company.entity;

import com.wanted.wantedpreonboardingbackend.jobadvertisement.entity.JobAdvertisement;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

// 회사
@Entity
@Getter
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "location", nullable = false)
    private String location;

    // 연관관계
    @OneToMany(mappedBy = "company", orphanRemoval = true)
    private List<JobAdvertisement> jobAdvertisements = new ArrayList<>();
}
