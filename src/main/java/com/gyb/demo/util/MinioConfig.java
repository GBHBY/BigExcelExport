package com.gyb.demo.util;

import io.minio.MinioClient;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MinioConfig {

    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.acessKey}")
    private String acessKey;

    @Value("${minio.secretLey}")
    private String secretLey;

    @Bean
    @SneakyThrows
    public MinioClient getInstance() {
        return new MinioClient(endpoint, acessKey, secretLey);
    }
}
