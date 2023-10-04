package com.wanted.wantedpreonboardingbackend.jobadvertisement.service;

import com.wanted.wantedpreonboardingbackend.company.entity.Company;
import com.wanted.wantedpreonboardingbackend.company.repository.CompanyRepository;
import com.wanted.wantedpreonboardingbackend.jobadvertisement.dto.*;
import com.wanted.wantedpreonboardingbackend.jobadvertisement.entity.JobAdvertisement;
import com.wanted.wantedpreonboardingbackend.jobadvertisement.repository.JobAdvertisementRepository;
import com.wanted.wantedpreonboardingbackend.user.entity.User;
import com.wanted.wantedpreonboardingbackend.user.repository.UserRepository;
import com.wanted.wantedpreonboardingbackend.userApplication.entity.UserApplication;
import com.wanted.wantedpreonboardingbackend.userApplication.repository.UserApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobAdvertisementService {
    private final JobAdvertisementRepository jobAdvertisementRepository;
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final UserApplicationRepository userApplicationRepository;

    // 1. 채용공고 등록
    @Transactional
    public void createJobAdvertisement(JobAdvertisementPostRequestDto requestDto) {
        Company company = findCompany(requestDto.getCompanyId());
        JobAdvertisement jobAdvertisement = new JobAdvertisement(requestDto, company);
        jobAdvertisementRepository.save(jobAdvertisement);
    }

    // 2. 채용공고 수정
    @Transactional
    public void modifyJobAdvertisement(Long jobAdvertisementId, JobAdvertisementPutRequestDto requestDto) {
        JobAdvertisement jobAdvertisement = findJobAdvertisement(jobAdvertisementId);
        jobAdvertisement.modify(requestDto);
    }

    // 3. 채용공고 삭제
    @Transactional
    public void deleteJobAdvertisement(Long jobAdvertisementId) {
        JobAdvertisement jobAdvertisement = findJobAdvertisement(jobAdvertisementId);
        jobAdvertisementRepository.delete(jobAdvertisement);
    }

    // 4-1. 채용공고 목록 전체 조회
    @Transactional(readOnly = true)
    public List<JobAdvertisementResponseDto> selectAllJobAdvertisements() {
        return jobAdvertisementRepository.findAll().stream()
                .map(JobAdvertisementResponseDto::new).toList();
    }

    // 4-2. 채용공고 검색
    @Transactional(readOnly = true)
    public List<JobAdvertisementResponseDto> selectSearchJobAdvertisements(String keyword) {
        return jobAdvertisementRepository.findByKeywordInColumns(keyword).stream()
                .map(JobAdvertisementResponseDto::new).toList();
    }

    // 5. 채용 상세 페이지 조회
    @Transactional(readOnly = true)
    public JobAdvertisementDetailResponseDto selectJobAdvertisement(Long jobAdvertisementId) {
        return new JobAdvertisementDetailResponseDto(findJobAdvertisement(jobAdvertisementId));
    }

    // 6. 사용자 채용공고 지원
    @Transactional
    public void createUserJobAdvertisement(Long jobAdvertisementId, UserApplicationRequestDto requestDto) {
        JobAdvertisement jobAdvertisement = findJobAdvertisement(jobAdvertisementId);
        User user = findUser(requestDto.getUserId());

        // 1회만 지원 가능
        if (findUserApplication(jobAdvertisement, user) != null) {
            throw new IllegalArgumentException("해당 공고에 이미 지원하셨습니다.");
        }
        userApplicationRepository.save(new UserApplication(jobAdvertisement, user));
    }


    // id로 채용공고 가져오기
    private JobAdvertisement findJobAdvertisement(Long jobAdvertisementId) {
        return jobAdvertisementRepository.findById(jobAdvertisementId).orElseThrow(() ->
                new IllegalArgumentException("선택한 채용공고는 존재하지 않습니다.")
        );
    }

    // id로 회사 가져오기
    private Company findCompany(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(() ->
                new IllegalArgumentException("선택한 회사는 존재하지 않습니다.")
        );
    }

    // id로 사용자 가져오기
    private User findUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("선택한 사용자는 존재하지 않습니다.")
        );
    }

    // 사용자와 채용공고로 사용자 지원 찾기
    private UserApplication findUserApplication(JobAdvertisement jobAdvertisement, User user) {
        return userApplicationRepository.findByJobAdvertisementAndUser(jobAdvertisement, user).orElse(null);
    }
}
