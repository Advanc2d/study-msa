package com.project.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.test.service.RestTemplateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {
	
	
    private RestTemplateService restTemplateService;

    @Autowired
    public TestController(RestTemplateService restTemplateService) {
        this.restTemplateService =restTemplateService;
    }
    
	@GetMapping("/test/info")
    public String info(@Value("${server.port}") String port) {
		log.info("/test/info info() 호출");
        return "Test 서비스의 포트번호 확인 Port: {" + port + "}";
    }
	
	@GetMapping("/test/rest")
    public ResponseEntity<?> restTemplateTest() throws JsonProcessingException {
		log.info("/test/rest restTemplateTest() 호출");
        return ResponseEntity.ok(restTemplateService.callExternalServer());
    }
	
	@GetMapping("/test/rest2")
    public ResponseEntity<?> restTemplateTest2() throws JsonProcessingException {
		log.info("/test/rest2 restTemplateTest2() 호출");
        return ResponseEntity.ok(restTemplateService.callPostExternalServer2());
    }

}
