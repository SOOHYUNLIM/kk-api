package com.kk.api.service.impl;

import com.kk.api.entity.Test;
import com.kk.api.repository.TestRepository;
import com.kk.api.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return testRepository.save(test);
    }
}
