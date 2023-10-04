package com.wanted.wantedpreonboardingbackend.userApplication.entity;

import com.wanted.wantedpreonboardingbackend.jobadvertisement.entity.JobAdvertisement;
import com.wanted.wantedpreonboardingbackend.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 지원내역
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_application")
public class UserApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_advertisement_id")
    private JobAdvertisement jobAdvertisement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public UserApplication(JobAdvertisement jobAdvertisement, User user) {
        this.jobAdvertisement = jobAdvertisement;
        this.user = user;
    }
}
