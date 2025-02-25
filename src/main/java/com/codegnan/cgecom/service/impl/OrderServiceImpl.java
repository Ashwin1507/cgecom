package com.codegnan.cgecom.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codegnan.cgecom.model.Order;
import com.codegnan.cgecom.model.User;
import com.codegnan.cgecom.repositories.OrderRepository;
import com.codegnan.cgecom.service.iface.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Transactional
	public void saveOrder(Order order) {
		orderRepository.save(order);
	}

	@Override

	public List<Order> getOrdersByUser(User user) {
		return orderRepository.findByUser(user);
	}// TODO Auto-generated method stub

}
