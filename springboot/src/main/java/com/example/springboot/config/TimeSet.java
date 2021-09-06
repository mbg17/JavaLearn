package com.example.springboot.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "timeset")
public class TimeSet {

    private final Map<String, Duration> config = new HashMap<>();

    public Map<String, Duration> getConfig() {
        return config;
    }
}
