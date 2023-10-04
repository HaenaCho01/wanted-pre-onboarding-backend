package com.wanted.wantedpreonboardingbackend.userJobadvertisement.repository;

import com.wanted.wantedpreonboardingbackend.userJobadvertisement.entity.UserJobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJobAdvertisementRepository extends JpaRepository<UserJobAdvertisement, Long> {
}
