package com.example.redis.util;
import java.util.Map;



import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientUtil {
	
	public static WebClient getBaseUrl(final String baseUrl) {
		WebClient webClient  = WebClient.builder()
										.baseUrl(baseUrl)
										.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
										.build();
		return webClient;
	}
	
	
	public static Map getWebClient(WebClient wbClient, String uri) {
		
		Map getWebClient = wbClient.get()
									.uri(uri)
									.accept(MediaType.APPLICATION_JSON)
									.retrieve()
									.bodyToMono(Map.class)
									.block();
		 
		 return getWebClient;
		
	}
	
	public static Map postWebClient(String authorization, WebClient wbClient, String uri, Map<String, Object> bodyValue) {
		
		Map postWebClient = wbClient.post()
									.uri(uri)
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.header("Authorization", authorization)
									.accept(MediaType.APPLICATION_JSON)
									.bodyValue(bodyValue)
									.retrieve()
									.bodyToMono(Map.class)
									.block();
		
		return postWebClient;
			
	}	
	
	public static Map postWebClientJSON(String authorization, WebClient wbClient, String uri, String bodyValue) {
		
		Map postWebClient = wbClient.post()
									.uri(uri)
									.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
									.header("Authorization", authorization)
									.accept(MediaType.APPLICATION_JSON)
									.bodyValue(bodyValue)
									.retrieve()
									.bodyToMono(Map.class)
									.block();
		
		return postWebClient;
			
	}	
}
