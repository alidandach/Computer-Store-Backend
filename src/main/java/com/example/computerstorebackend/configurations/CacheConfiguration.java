package com.example.computerstorebackend.configurations;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CacheConfiguration {
    @Bean
    public CacheManager getCacheManager() {
        return new ConcurrentMapCacheManager("processor", "memory", "hardDisk");
    }
}
