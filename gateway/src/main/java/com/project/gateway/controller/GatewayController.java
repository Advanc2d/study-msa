package com.project.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
	
	@GetMapping("/info")
	public String info(@Value("${server.port}") String port) {
		return "Gateway 서비스의 포트번호 확인 Port: {" + port + "}";
	}
}
