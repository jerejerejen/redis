package com.example.redis.fetcher;


public interface DataFetcher {
	
    String fetchData(String group, String key);
    
    void saveData(String group, String key, String value);
    
}
