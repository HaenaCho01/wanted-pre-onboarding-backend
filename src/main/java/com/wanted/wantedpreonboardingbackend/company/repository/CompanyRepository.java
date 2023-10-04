package com.wanted.wantedpreonboardingbackend.company.repository;

import com.wanted.wantedpreonboardingbackend.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}