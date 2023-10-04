package com.wanted.wantedpreonboardingbackend.user.repository;

import com.wanted.wantedpreonboardingbackend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
