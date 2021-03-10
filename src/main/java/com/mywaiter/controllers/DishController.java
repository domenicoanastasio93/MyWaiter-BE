package com.mywaiter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywaiter.builders.DishBuilder;
import com.mywaiter.dto.DishDTO;
import com.mywaiter.models.Dish;
import com.mywaiter.services.DishService;

@RestController
@RequestMapping("dishes")
public class DishController {

	@Autowired
	private DishService dishService;

	@Autowired
	private DishBuilder dishBuilder;

	@GetMapping("category/{categoryId}")
	public ResponseEntity<List<DishDTO>> createOrder(@PathVariable("categoryId") Integer categoryId) {
		ResponseEntity<List<DishDTO>> ret = null;
		List<DishDTO> dListDTO = null;
		try {
			List<Dish> dList = dishService.retrieveDishesByCategoryId(categoryId);
			dListDTO = dishBuilder.buildDishDTOList(dList);
			ret = new ResponseEntity<List<DishDTO>>(dListDTO, HttpStatus.OK);
		} catch (Exception ex) {
			ret = new ResponseEntity<List<DishDTO>>(dListDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ret;
	}
}
