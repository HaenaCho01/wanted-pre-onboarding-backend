package com.wanted.wantedpreonboardingbackend.jobadvertisement.controller;

import com.wanted.wantedpreonboardingbackend.common.dto.ApiResponseDto;
import com.wanted.wantedpreonboardingbackend.jobadvertisement.dto.*;
import com.wanted.wantedpreonboardingbackend.jobadvertisement.service.JobAdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class JobAdvertisementController {
    private final JobAdvertisementService jobAdvertisementService;

    // 1. 채용공고 등록
    @PostMapping("/job-advertisements")
    public ResponseEntity<ApiResponseDto> createJobAdvertisement(@RequestBody JobAdvertisementPostRequestDto requestDto) {
        jobAdvertisementService.createJobAdvertisement(requestDto);
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.CREATED.value(), "채용 공고를 등록했습니다."));
    }

    // 2. 채용공고 수정
    @PutMapping("/job-advertisements/{jobAdvertisementId}")
    public ResponseEntity<ApiResponseDto> modifyJobAdvertisement(@PathVariable Long jobAdvertisementId, @RequestBody JobAdvertisementPutRequestDto requestDto) {
        jobAdvertisementService.modifyJobAdvertisement(jobAdvertisementId, requestDto);
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.OK.value(), "채용 공고를 수정했습니다."));
    }

    // 3. 채용공고 삭제
    @DeleteMapping("/job-advertisements/{jobAdvertisementId}")
    public ResponseEntity<ApiResponseDto> deleteJobAdvertisement(@PathVariable Long jobAdvertisementId) {
        jobAdvertisementService.deleteJobAdvertisement(jobAdvertisementId);
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.NO_CONTENT.value(), "채용 공고를 삭제했습니다."));
    }

    // 4-1. 채용공고 목록 전체 조회
    @GetMapping("/job-advertisements")
    public ResponseEntity<List<JobAdvertisementResponseDto>> selectAllJobAdvertisements() {
        List<JobAdvertisementResponseDto> result = jobAdvertisementService.selectAllJobAdvertisements();
        return ResponseEntity.ok().body(result);
    }

    // 4-2. 채용공고 검색
    @GetMapping("/job-advertisements/search")
    public ResponseEntity<List<JobAdvertisementResponseDto>> selectSearchJobAdvertisements(@RequestParam(value = "keyword") String keyword) {
        List<JobAdvertisementResponseDto> result = jobAdvertisementService.selectSearchJobAdvertisements(keyword);
        return ResponseEntity.ok().body(result);
    }

    // 5. 채용 상세 페이지 조회
    @GetMapping("/job-advertisements/{jobAdvertisementId}")
    public ResponseEntity<JobAdvertisementDetailResponseDto> selectJobAdvertisement(@PathVariable Long jobAdvertisementId) {
        JobAdvertisementDetailResponseDto result = jobAdvertisementService.selectJobAdvertisement(jobAdvertisementId);
        return ResponseEntity.ok().body(result);
    }

    // 6. 사용자 채용공고 지원
    @PostMapping("/job-advertisements/{jobAdvertisementId}/application")
    public ResponseEntity<ApiResponseDto> createUserJobAdvertisement(@PathVariable Long jobAdvertisementId, @RequestBody UserApplicationRequestDto requestDto) {
        jobAdvertisementService.createUserJobAdvertisement(jobAdvertisementId, requestDto);
        return ResponseEntity.ok().body(new ApiResponseDto(HttpStatus.CREATED.value(), "해당 채용 공고에 지원했습니다."));
    }
}
