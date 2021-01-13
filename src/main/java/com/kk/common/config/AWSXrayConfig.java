package com.kk.common.config;

import com.amazonaws.xray.AWSXRay;
import com.amazonaws.xray.AWSXRayRecorder;
import com.amazonaws.xray.AWSXRayRecorderBuilder;
import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;
import com.amazonaws.xray.plugins.EC2Plugin;
import com.amazonaws.xray.plugins.ElasticBeanstalkPlugin;
import com.amazonaws.xray.strategy.DefaultStreamingStrategy;
import com.amazonaws.xray.strategy.sampling.LocalizedSamplingStrategy;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import java.io.IOException;
import java.net.URL;

@Configuration
public class AWSXrayConfig {

    @PostConstruct
    public void init() {
        AWSXRayRecorderBuilder builder = AWSXRayRecorderBuilder.standard().withPlugin(new EC2Plugin());
        URL ruleFile = AWSXrayConfig.class.getResource("/aws-xray/rules.json");
        builder.withSamplingStrategy(new LocalizedSamplingStrategy(ruleFile));
        AWSXRayRecorder globalRecorder = builder.build();
        AWSXRay.setGlobalRecorder(globalRecorder);
        AWSXRay.beginSegment("kk-api");
    }

    @Bean
    public Filter TracingFilter() {
        return new AWSXRayServletFilter("kk-api");
    }
}
