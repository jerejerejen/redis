package com.example.redis.proxy;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.redis.cache.RedisProxy;
import com.example.redis.fetcher.AuthDataFetcher;
import com.example.redis.service.AuthService;

@SpringBootTest
class RedisProxyTest {
	
//	@Autowired
//	AuthDataFetcher authDataFetcher;
	
	//@Autowired
	//private RedisCache cache;

	@Autowired	
	private AuthService authService;

	@Autowired
	private RedisProxy redisProxy;
	
	@Test
	void testGet() {
		
		redisProxy.connect(new AuthDataFetcher(authService));

		System.out.println("데이터 요청 테스트를 시작합니다. ");
		
		String data = redisProxy.get("group1", "key1");
		
		System.out.println("요청한 데이터를 반환합니다. "+data);
	}

//	@Test
//	void testSet() {
//		System.out.println("데이터 저장 테스트를 시작합니다. ");
//		redisProxy.create(authDataFetcher);
//
//		//System.out.println("Redis에 해당 데이터가 존재하는지 확인합니다. 결과: " + cache.get("group1", "key1"));
//		
//		redisProxy.set("group1", "key1", "value1");
//		
//		//이 과정때문에 RedisCache 클래스를 public으로 임시 선언 해놓았음.
//		//System.out.println("Redis에 해당 데이터가 삭제되었는지 확인합니다. 결과: " + cache.get("group1", "key1"));
//	}
//
//	@Test
//	void testClear() {
//		redisProxy.create(authDataFetcher);
//		
//		System.out.println("데이터 삭제 테스트를 시작합니다. ");
//
//		redisProxy.clear("group1", "key1");
//		
//		//System.out.println("Redis에 해당 데이터가 삭제되었는지 확인합니다. 결과: " + cache.get("group1", "key1"));
//	}
//
//	@Test
//	void testLoad() {
//		redisProxy.create(authDataFetcher);
//		System.out.println("데이터 적재 테스트를 시작합니다. ");
//
//		redisProxy.load("group1", "key1");
//		//System.out.println("Redis에 해당 데이터가 저장되었는지 확인합니다. 결과: " + cache.get("group1", "key1"));
//	}
//	
//
//	@Test
//	void testGetSearch() {
//		redisProxy.create(authDataFetcher);
//
//		String data = redisProxy.get("group1", "key1", "searchKey1");
//		
//		System.out.println("data: "+data);
//	}
//
//	@Test
//	void testClearGroup() {
//		redisProxy.create(authDataFetcher);
//
//		redisProxy.clear("group1");
//	}
	
}
