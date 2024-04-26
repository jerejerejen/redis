package com.example.redis.cache;

import java.util.Map;

import org.springframework.stereotype.Component;
import com.example.redis.fetcher.DataFetcher;

@Component
public class RedisProxy{

	private final RedisRepository redisRepository;
	private DataFetcher dataFetcher;
	
	public RedisProxy(RedisRepository redisRepository) {
		this.redisRepository = redisRepository;
	}
	
	public void connect(DataFetcher dataFetcher) {
		this.dataFetcher = dataFetcher;
	}
	
	public String get(String group, String key) {
		String value = redisRepository.get(key);

		if(value.equals("null")) {
			if(dataFetcher != null) {
				value = dataFetcher.fetchData(group, key);
				redisRepository.set(key, value);
				System.out.println("DataFetcher에서 가져온 데이터를 Redis에 저장합니다.");
			} else {
				System.out.println("DataFetcher 객체가 비었습니다");
			}
		}else System.out.println("Redis 에서 데이터를 가져옵니다.");
		return value;
	}
	
	public void set(String group, String key, String value) {
		try {
			if(dataFetcher != null) {
				dataFetcher.saveData(group, key, value);
			} else {
				System.out.println("DataFetcher 객체가 비었습니다");
			}
		} finally {
			redisRepository.clear(key);
			System.out.println("Redis 에서 해당 데이터를 삭제합니다.");
		}
	}
	
	public void clear(String group, String key) {
		redisRepository.clear(key);
		System.out.println("Redis 에서 해당 데이터를 삭제합니다.");
	}

	public void load(String group, String key) {
		String value = "";
		try {
			if(dataFetcher != null) {
				value = dataFetcher.fetchData(group, key);
			} else {
				System.out.println("DataFetcher 객체가 비었습니다");
			}
		} finally {
			redisRepository.set(key, value);
			System.out.println("DataFetcher에서 가져온 데이터를 Redis에 저장합니다.");
		}
	}
	
//	public String get(String group, String key, String searchKey) {
//		String value = redisRepository.get(key+searchKey);
//		if(value == null) {
//			try {
//				if(dataFetcher != null) {
//					value = dataFetcher.fetchData(group, key, searchKey);
//				} else {
//					System.out.println("DataFetcher 객체가 비었습니다");
//				}
//			} finally {
//				redisRepository.set(key+searchKey, value);
//				System.out.println("DataFetcher에서 가져온 데이터를 Redis에 저장합니다.");
//			}
//		}
//		return value;
//	}
//	
//	public void clear(String group) {
//		
//	}
//	
//	public void set(String group, String key, String value, int ttl) {
//		// TODO Auto-generated method stub
//		
//	}
	
//	public String generateKey(String key) {
//		System.out.println("키를 생성합니다.");
//		return key;
//	}
	
	public String hit(String key, String field) {
		//key: userId
		//field: 저장할 데이터 key
		
		return redisRepository.hIncrBy(key, field, 1);
	}
	
	public String getHit(String key, String field) {
		return redisRepository.hGet(key, field);
	}
	
	public Map<Object, Object> getHitAll(String key) {
		return redisRepository.hGetAll(key);
	}
	
	
}