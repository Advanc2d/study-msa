package com.project.aop.v1;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
	private OrderRepositoryV1 orderRepository;

	public void orderItem(String itemId) {
		orderRepository.save(itemId);
	}
}
