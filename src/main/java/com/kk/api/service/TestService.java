package com.kk.api.service;

import com.kk.api.entity.Test;

import java.util.List;

public interface TestService {

    List<Test> getAllTest();

    Test registerTest(Test test);
}
