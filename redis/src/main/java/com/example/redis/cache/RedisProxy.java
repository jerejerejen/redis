package com.example.redis.cache;

import org.springframework.stereotype.Component;
import com.example.redis.fetcher.DataFetcher;

@Component
public class RedisProxy implements IRedis{

	private final RedisCache cache;
	private DataFetcher dataFetcher;

    RedisProxy(RedisCache cache) {
        this.cache = cache;
    }
	
	public void connect(DataFetcher dataFetcher) {
		this.dataFetcher = dataFetcher;
	}
	
	@Override
	public String get(String group, String key) {
		String value = cache.get(group, key);

		if(value == null) {
			value = dataFetcher.fetchData(group, key);
			cache.set(group, key, value);
			System.out.println("DataFetcher에서 가져온 데이터를 Redis에 저장합니다.");
			
		}else System.out.println("Redis 에서 데이터를 가져옵니다.");
		return value;
	}

	@Override
	public void set(String group, String key, String value) {
		dataFetcher.saveData(group, key, value);
		cache.clear(group, key);
		System.out.println("Redis 에서 해당 데이터를 삭제합니다.");
		
	}

	@Override
	public void clear(String group, String key) {
		cache.clear(group, key);
		System.out.println("Redis 에서 해당 데이터를 삭제합니다.");
	}

	public void load(String group, String key) {
		String value = dataFetcher.fetchData(group, key);
		cache.set(group, key, value);
		System.out.println("DataFetcher에서 가져온 데이터를 Redis에 저장합니다.");
	}
	
	public String get(String group, String key, String searchKey) {
		String value = cache.get(group, key+searchKey);

		if(value == null) {
			value = dataFetcher.fetchData(group, key, searchKey);
			cache.set(group, key+searchKey, value);
			
		}
		return value;
	}
	
	public void clear(String group) {
		
	}

	@Override
	public void set(String group, String key, String value, int ttl) {
		// TODO Auto-generated method stub
		
	}
}