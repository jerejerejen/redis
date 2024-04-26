package com.example.redis.proxy;



import java.util.concurrent.CountDownLatch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.redis.cache.RedisProxy;

import lombok.RequiredArgsConstructor;

@SpringBootTest
class RedisProxyTest {
	
//	@Autowired
//	AuthDataFetcher authDataFetcher;
	
	//@Autowired
	//private RedisCache cache;

	@Autowired
	private RedisProxy redisProxy;
	
//	@Autowired
//	public RedisProxyTest(RedisProxy redisProxy) {
//		this.redisProxy = redisProxy;
//	}
//	@Autowired
//	private RedisProxy redisProxy;
	
	@Test
	void testGet() {
		System.out.println(redisProxy);
		
		System.out.println("데이터 요청 테스트를 시작합니다. ");
		
		System.out.println("요청한 데이터를 반환합니다. "+redisProxy.get("group1", "key1"));
	}
	
//	@Test
//	void testHit() {
//        
//		System.out.println("redis get hit: "+redisProxy.getHit("user:234", "api:4234"));
//		System.out.println("redis set hit: "+redisProxy.hit("user:234", "api:4234"));                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
//		System.out.println("redis get hit: "+redisProxy.getHit("user:234", "api:4234"));
//
//		System.out.println("redis get hit: "+redisProxy.getHit("user:234", "api:0000"));
//		System.out.println("redis set hit: "+redisProxy.hit("user:234", "api:0000"));                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
//		System.out.println("redis get hit: "+redisProxy.getHit("user:234", "api:0000"));
//		
//		System.out.println("user:234에 대하여 모든 속성 값 출력"+redisProxy.getHitAll("user:234"));	
//	}
	
//	@Test
//	void 동시에_100개_요청() throws InterruptedException{
//		int threadCount = 100;
//		ExecutorService executorService = Executors.newFixedThreadPool(32);
//		CountDownLatch latch = new CountDownLatch(threadCount);
//		
//	    for(int i=0; i<threadCount; i++){
//	        executorService.submit(()->{
//	            try{
//	            	redisProxy.hit("user:234", "api:1111");
//	            } finally {
//	                latch.countDown();
//	            }
//	        });
//	    }
//	    
//	    latch.await();
//	    String hits = redisProxy.getHit("user:234", "api:1111");
//	    
//	    System.out.println("hits: "+hits);
//	}
	

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
