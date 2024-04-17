package com.example.redis.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.redis.util.WebClientUtil;
 
@Service
public class AuthService {

	public String getClientInfo() {
		WebClient webClient = WebClientUtil.getBaseUrl("http://localhost:8082");
		
		Map<String, Object> body = new HashMap<String, Object>();
		
		body.put("size", "5");
		body.put("page", "1");
		body.put("orderType", "SBS_END_DT_TM");
		body.put("orderMethod", "DESC");
		
		Map<String, Object> response = WebClientUtil.postWebClient("Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2b3RlMDFAYXNzZXQuY29tIiwiZXhwIjoxNzEyMjgwODAzfQ.gTGyyI_UvLVrGsw6sisrWsnzV_3PJLFVmH1oL-MgImM", webClient, "/stx-api/po/subscription/select/list", body);
		//Map<String, Object> result = (Map<String, Object>) response.get("data");
	
		//System.out.println("response: "+response);
		
		return String.valueOf(response);
			
	}
}
