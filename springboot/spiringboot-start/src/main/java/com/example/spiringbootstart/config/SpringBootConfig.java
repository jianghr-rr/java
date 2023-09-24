package com.example.spiringbootstart.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "joge")
public class SpringBootConfig {
    private String name;
}
