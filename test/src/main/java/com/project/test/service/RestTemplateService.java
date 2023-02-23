package com.project.test.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RestTemplateService {
	private ApiService apiService;

    @Autowired
    public RestTemplateService(ApiService apiService) {
        this.apiService = apiService;
    }

    public String callExternalServer() {
    	Object result = apiService.get("http://localhost:4001/demo/services", HttpHeaders.EMPTY).getBody();
    	
    	// List<String> result = apiService.post("http://localhost:4001/demo/services", HttpHeaders.EMPTY, null).getBody();
        return result.toString();
    }
    
    public String callPostExternalServer2() throws JsonProcessingException {
    	HashMap<String, Object> result = new HashMap<String, Object>();
        String jsonInString = "";

        RestTemplate restTemplate = new RestTemplate();
    	HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);
        ResponseEntity<?> resultMap = restTemplate.exchange("http://localhost:4001/demo/services", HttpMethod.POST, entity , Object.class);
		result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
		result.put("header", resultMap.getHeaders()); //헤더 정보 확인
		result.put("body", resultMap.getBody()); //실제 데이터 정보 확인

        ObjectMapper mapper = new ObjectMapper();
        jsonInString = mapper.writeValueAsString(result.get("body"));

    	return jsonInString; 
    }
}
