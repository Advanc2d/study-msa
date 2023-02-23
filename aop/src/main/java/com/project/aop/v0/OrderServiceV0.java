package com.project.aop.v0;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV0 {
	private OrderRepositoryV0 orderRepository;

	public void orderItem(String itemId) {
		orderRepository.save(itemId);
	}
}
