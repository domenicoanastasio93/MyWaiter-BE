package com.mywaiter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywaiter.builders.OrderBuilder;
import com.mywaiter.dto.OrderDTO;
import com.mywaiter.models.Order;
import com.mywaiter.services.OrderService;

@RestController
@RequestMapping("orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderBuilder orderBuilder;

	@PostMapping
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO body) {
		ResponseEntity<OrderDTO> ret = null;
		OrderDTO oDTO = null;
		try {
			Order o = orderService.createOrEditOrder(body);
			oDTO = orderBuilder.buildOrderDTO(o);
			ret = new ResponseEntity<OrderDTO>(oDTO, HttpStatus.OK);
		} catch (Exception ex) {
			ret = new ResponseEntity<OrderDTO>(oDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ret;
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Integer> deleteOrder(@PathVariable("id") Integer id) {
		ResponseEntity<Integer> ret = null;
		try {
			orderService.deleteById(id);
			ret = new ResponseEntity<Integer>(id, HttpStatus.OK);
		} catch (Exception ex) {
			ret = new ResponseEntity<Integer>(id, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ret;
	}
}
