package com.ge.testservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import brave.sampler.Sampler;

@Configuration
public class CustomSampler {
    @Bean
    public Sampler smartSampler(){

        return new Sampler() {
            @Override
            public boolean isSampled(long l) {
                return true;
            }
        };
    }
}
