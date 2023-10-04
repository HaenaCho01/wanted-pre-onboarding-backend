package com.wanted.wantedpreonboardingbackend.jobadvertisement.repository;

import com.wanted.wantedpreonboardingbackend.jobadvertisement.entity.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Long> {
}
