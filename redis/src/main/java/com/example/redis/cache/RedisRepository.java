package com.example.redis.cache;

import java.time.Duration;
import java.util.Map;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RedisRepository {
    private final RedisTemplate<String, Object> redisTemplate;
    
    private final int DEFAULT_TTL = 5;
    
	protected String get(String key) {
        return String.valueOf(redisTemplate.opsForValue().get(key));
	}
	protected void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value, Duration.ofMinutes(DEFAULT_TTL)); // 5분 뒤 메모리에서 삭제된다.
	}
	protected void set(String key, String value, int ttl) {
        redisTemplate.opsForValue().set(key, value, Duration.ofMinutes(ttl)); 	//${ttl}분 뒤 메모리에서 삭제된다.
	}
	protected Boolean clear(String key) {
		return redisTemplate.delete(key);	// 성공 시 1 반환
	}
	protected Boolean lock(String key) {
		return redisTemplate
				.opsForValue().setIfAbsent(key, "lock", Duration.ofMillis(3000));
	}
	protected Boolean unlock(String key) {
		return redisTemplate.delete(key);
	}
	protected String hIncrBy(String key, String field, long value) {
		return String.valueOf(redisTemplate.opsForHash().increment(key, field, value));
	}
	protected String hGet(String key, String field) {
		return String.valueOf(redisTemplate.opsForHash().get(key, field));
	}
	protected Map<Object, Object> hGetAll(String key) {
		return redisTemplate.opsForHash().entries(key);

	}
	protected void addHyperLogLog(String key) {
		redisTemplate.opsForHyperLogLog().add("202211:user:245", "49483");
	}
}
