package com.gc.easy.flv.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "easy.flv")
@Data
@Component
public class FlvConfig {
    private String host;
    private Integer wight=1920;
    private Integer height=1080;

}
