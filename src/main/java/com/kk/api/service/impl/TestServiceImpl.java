package com.kk.api.service.impl;

import com.kk.api.entity.Test;
import com.kk.api.repository.TestRepository;
import com.kk.api.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Override
    public List<Test> getAllTest() {
        return testRepository.findAll();
    }

    @Override
    public Test registerTest(Test test) {
        Test newTest = testRepository.save(test);
        log.info("Register Test... > {}", test);
        return newTest;
    }
}
