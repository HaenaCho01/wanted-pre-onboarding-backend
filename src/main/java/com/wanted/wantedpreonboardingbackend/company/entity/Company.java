package com.wanted.wantedpreonboardingbackend.company.entity;

import jakarta.persistence.*;
import lombok.Getter;

// 회사
@Entity
@Getter
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
