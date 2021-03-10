package com.mywaiter.services;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mywaiter.dto.OrderDTO;
import com.mywaiter.models.Order;
import com.mywaiter.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	private static ObjectMapper objectMapper = new ObjectMapper();

	public Order createOrEditOrder(OrderDTO body) throws Exception {
		Order ret = null;
		boolean isCreation = false;
		if (body.getId() == null) {
			ret = new Order();
			isCreation = true;
		} else {
			ret = this.retrieveById(body.getId());
		}

		if (body.getOrderList() != null && !body.getOrderList().isEmpty()) {
			String jsonOrderList = objectMapper.writeValueAsString(body.getOrderList());
			ret.setJsonOrderList(jsonOrderList);
		} else {
			if (isCreation) {
				throw new Exception("categories list is null");
			}
		}
		if (body.getTable() != null) {
			ret.setTable(body.getTable());
		} else {
			if (isCreation) {
				throw new Exception("table is null");
			}
		}
		if (body.getAdditiveNotes() != null && body.getAdditiveNotes() != "") {
			ret.setAdditiveNotes(body.getAdditiveNotes());
		}

		if (!isCreation) {
			Timestamp now = Timestamp.from(Instant.now());
			ret.setUpdateDate(now);
		}

		ret = orderRepository.saveAndFlush(ret);
		return ret;
	}

	public Order retrieveById(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("id is null");
		}
		Optional<Order> optO = orderRepository.findById(id);
		if (optO.isEmpty()) {
			throw new Exception("order is null for id: " + id);
		}
		return optO.get();
	}

	public void deleteById(Integer id) throws Exception {
		Order o = this.retrieveById(id);
		orderRepository.delete(o);
	}

}
