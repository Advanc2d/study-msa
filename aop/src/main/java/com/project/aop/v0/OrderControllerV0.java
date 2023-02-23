package com.project.aop.v0;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderControllerV0 {
	private OrderServiceV0 orderService;

	@GetMapping("/v0/request")
	public String request(String itemId) {
		orderService.orderItem(itemId);
		return "ok";
	}
}
