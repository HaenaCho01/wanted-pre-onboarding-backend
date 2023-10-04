package com.wanted.wantedpreonboardingbackend.userJobadvertisement.entity;

import com.wanted.wantedpreonboardingbackend.jobadvertisement.entity.JobAdvertisement;
import com.wanted.wantedpreonboardingbackend.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;

// 사용자 - 채용공고 연결
@Entity
@Getter
@Table(name = "user_job_advertisement")
public class UserJobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_advertisement_id")
    private JobAdvertisement jobAdvertisement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
