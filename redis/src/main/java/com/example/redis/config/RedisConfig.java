package com.example.redis.config;

import org.springframework.beans.factory.annotation.Value;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Value("${spring.data.redis.host}")
    private String redisHost;
 
    @Value("${spring.data.redis.port}")
    private int redisPort;
 
    @Bean
    RedisConnectionFactory redisConnectionFactory() {
    	// RedisConnectionFactory 를 통해 Redis 저장소와 연결
    	// Lettuce 사용
        return new LettuceConnectionFactory(redisHost, redisPort);
    }
 
    @Bean(name = "redisTemplate")
    RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
 
        redisTemplate.setConnectionFactory(redisConnectionFactory());
 
        // RedisTemplate의 Default 직렬화, 역직렬화 방식이 Jdk 직렬화 방식
        // Jdk 직렬화 방식을 사용하면 redis 서버에서 데이터를 조회할 시, 바이트 형태로 출력됨.
        // 따라서 StringRedisSerializer를 이용하여 String 형태로 출력되게 끔 설정함.
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
 
        // Hash를 사용할 경우 Serializer
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        
        return redisTemplate;
    }
}
