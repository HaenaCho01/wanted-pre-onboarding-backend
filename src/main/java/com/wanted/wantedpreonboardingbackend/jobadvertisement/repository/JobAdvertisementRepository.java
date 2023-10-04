package com.wanted.wantedpreonboardingbackend.jobadvertisement.repository;

import com.wanted.wantedpreonboardingbackend.jobadvertisement.entity.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Long> {
    @Query("SELECT j FROM JobAdvertisement j " +
            "LEFT JOIN j.company c " +
            "WHERE " +
            "j.position LIKE %:keyword% OR " +
            "j.description LIKE %:keyword% OR " +
            "j.skill LIKE %:keyword% OR " +
            "c.name LIKE %:keyword% OR " +
            "c.country LIKE %:keyword% OR " +
            "c.location LIKE %:keyword%")
    List<JobAdvertisement> findByKeywordInColumns(String keyword);
}
