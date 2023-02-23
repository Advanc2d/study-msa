package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.service.DemoService;

@RestController
public class DemoController {

	@Autowired
	DemoService demoService;

	@GetMapping("/demo/info")
	public String info(@Value("${server.port}") String port) {
		return "Demo 서비스의 포트번호 확인 Port: {" + port + "}";
	}

	@GetMapping(value = "/demo/services")
	public List<String> servicesGet() {
		return demoService.getServices();
	}

	@PostMapping(value = "/demo/services")
	public List<String> servicesPost() {
		return demoService.getServices();
	}
}
