package com.mywaiter.services;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywaiter.dto.DishDTO;
import com.mywaiter.models.Category;
import com.mywaiter.models.Dish;
import com.mywaiter.repositories.DishRepository;

@Service
public class DishService {

	@Autowired
	private DishRepository dishRepository;

	@Autowired
	private CategoryService categoryService;

	public Dish createOrEditDish(DishDTO body) throws Exception {
		Dish ret = null;
		boolean isCreation = false;
		if (body.getId() == null) {
			ret = new Dish();
			isCreation = true;
		} else {
			ret = this.retrieveById(body.getId());
		}

		if (body.getCategoryId() != null) {
			Category c = categoryService.retrieveById(body.getCategoryId());
			ret.setCategory(c);
		} else {
			if (isCreation) {
				throw new Exception("categoryId is null");
			}
		}
		if (body.getName() != null && body.getName() != "") {
			ret.setName(body.getName());
		} else {
			if (isCreation) {
				throw new Exception("name is null");
			}
		}
		if (body.getOrder() != null) {
			ret.setOrder(body.getOrder());
		}
		if (body.getDescriptionEn() != null && body.getDescriptionEn() != "") {
			ret.setDescriptionEn(body.getDescriptionEn());
		}
		if (body.getDescriptionIt() != null && body.getDescriptionIt() != "") {
			ret.setDescriptionIt(body.getDescriptionIt());
		}
		if (body.getPrice() != null) {
			if (body.getPrice() <= 0) {
				throw new Exception("invalid price value");
			}
			ret.setPrice(body.getPrice());
		} else {
			if (isCreation) {
				throw new Exception("price is null");
			}
		}

		if (!isCreation) {
			Timestamp now = Timestamp.from(Instant.now());
			ret.setUpdateDate(now);
		}

		ret = dishRepository.saveAndFlush(ret);
		return ret;
	}

	public List<Dish> retrieveDishesByCategoryId(Integer categoryId) throws Exception {
		if (categoryId == null) {
			throw new Exception("input param null");
		}
		List<Dish> ret = dishRepository.findByCategoryIdOrdered(categoryId);
		return ret;
	}

	public Dish retrieveById(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("id is null");
		}
		Optional<Dish> optD = dishRepository.findById(id);
		if (optD.isEmpty()) {
			throw new Exception("dish is null for id: " + id);
		}
		return optD.get();
	}

}
