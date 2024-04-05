package com.example.demo;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfiguration {
    private final static int TEN_MINUTES = 600000;
    @Bean
    public CacheManager cacheManager(){
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        cacheManager.setAllowNullValues(false); //  If method returns null value it will not save it to teh cache
        cacheManager.setCacheNames(Arrays.asList("productCache", "customerCache"));
        System.out.println("Here are the product names " +  cacheManager.getCacheNames());
        return cacheManager;
    }
    @CacheEvict(value = "productCache", allEntries = true)
    @Scheduled(fixedDelay = TEN_MINUTES, initialDelay = 0)
    public void evictProductCache(){
        System.out.println("Evicting product cache...");
    }
}
