package com.kk.api.controller;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.kk.api.entity.Test;
import com.kk.api.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@XRayEnabled
@RequiredArgsConstructor
@RequestMapping("/v1/test")
@RestController
public class TestController {

    private final TestService testService;

    @GetMapping("/get-all")
    public List<Test> getAllTest() {
        return testService.getAllTest();
    }

    @PostMapping("/registration")
    public Test registration(@RequestBody Test test) {
        return testService.registerTest(test);
    }
}
