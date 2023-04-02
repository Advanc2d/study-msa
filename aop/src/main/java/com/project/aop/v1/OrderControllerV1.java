package com.project.aop.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {
	private OrderServiceV1 orderService;

	@GetMapping("/v1/request")
	public String request(String itemId) {
		orderService.orderItem(itemId);
		return "ok";
	}
}
