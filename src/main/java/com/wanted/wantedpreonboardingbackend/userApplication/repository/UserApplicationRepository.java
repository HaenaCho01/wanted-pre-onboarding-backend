package com.wanted.wantedpreonboardingbackend.userApplication.repository;

import com.wanted.wantedpreonboardingbackend.jobadvertisement.entity.JobAdvertisement;
import com.wanted.wantedpreonboardingbackend.user.entity.User;
import com.wanted.wantedpreonboardingbackend.userApplication.entity.UserApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserApplicationRepository extends JpaRepository<UserApplication, Long> {
    Optional<UserApplication> findByJobAdvertisementAndUser(JobAdvertisement jobAdvertisement, User user);
}
