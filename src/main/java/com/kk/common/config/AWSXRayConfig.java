package com.kk.common.config;

import com.amazonaws.xray.AWSXRay;
import com.amazonaws.xray.AWSXRayRecorder;
import com.amazonaws.xray.AWSXRayRecorderBuilder;
import com.amazonaws.xray.plugins.EC2Plugin;
import com.amazonaws.xray.strategy.sampling.LocalizedSamplingStrategy;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.net.URL;

@Configuration
public class AWSXRayConfig {

    @PostConstruct
    public void init() {
        URL ruleFile = AWSXRayConfig.class.getResource("/sampling-rules.json");
        AWSXRayRecorder globalRecorder = AWSXRayRecorderBuilder.standard().withPlugin(new EC2Plugin())
                .withSamplingStrategy(new LocalizedSamplingStrategy(ruleFile)).build();
        AWSXRay.setGlobalRecorder(globalRecorder);
        AWSXRay.beginSegment("kk-api");
        AWSXRay.endSegment();
    }
}
