package com.example.redis.cache;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisServiceTest2 {
	
	@Autowired
	RedisService redisService;

	@Test
	void test() {
		redisService.addHyperLogLog("hello");
	}

}
