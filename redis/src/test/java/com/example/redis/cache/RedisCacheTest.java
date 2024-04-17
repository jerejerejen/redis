package com.example.redis.cache;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisCacheTest {
	
	@Autowired
	private RedisProxy redisProxy;

	@Test
	void testRedisCache() {
		System.out.println(redisProxy);
	}
}
