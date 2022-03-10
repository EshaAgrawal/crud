package com.springbootcrudexample.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableCaching
@EnableJpaRepositories(basePackages = "com.springbootcrudexample.repository")
public class HazelCastConfig {

    @Bean
    public HazelcastInstance hazelcastInstance() {

        Config config = new Config();
        // MapConfig configuration
        MapConfig mapConfig = new MapConfig();
        mapConfig.setName("product");
        mapConfig.setTimeToLiveSeconds(60);

        config.setInstanceName("springbootcrudexample_hazelcast");
        config.addMapConfig(mapConfig);
        return Hazelcast.newHazelcastInstance(config);
    }
}