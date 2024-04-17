package com.example.redis.fetcher;


public interface DataFetcher {
	
    String fetchData(String group, String key);
	
    String fetchData(String group, String key, String searchKey);
    
    void saveData(String group, String key, String value);
    
}
