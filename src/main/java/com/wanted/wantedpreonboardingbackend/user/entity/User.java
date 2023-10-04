package com.wanted.wantedpreonboardingbackend.user.entity;

import jakarta.persistence.*;
import lombok.Getter;

// 사용자
@Entity
@Getter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
