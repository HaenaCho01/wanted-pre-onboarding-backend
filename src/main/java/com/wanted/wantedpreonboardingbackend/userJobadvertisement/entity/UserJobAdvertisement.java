package com.wanted.wantedpreonboardingbackend.userJobadvertisement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

// 사용자 - 채용공고 연결
@Entity
@Getter
public class UserJobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
