package com.mywaiter.builders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mywaiter.dto.DishDTO;
import com.mywaiter.models.Dish;

@Service
public class DishBuilder {

	public DishDTO buildDishDTO(Dish d) {
		if (d == null) {
			return null;
		}

		DishDTO ret = new DishDTO();
		ret.setId(d.getId());
		if (d.getCategory() != null) {
			ret.setCategoryId(d.getCategory().getId());
		}
		ret.setName(d.getName());
		ret.setOrder(d.getOrder());
		ret.setDescriptionEn(d.getDescriptionEn());
		ret.setDescriptionIt(d.getDescriptionIt());
		ret.setPrice(d.getPrice());
		ret.setCreationDate(d.getCreationDate());
		ret.setUpdateDate(d.getUpdateDate());
		return ret;
	}

	public List<DishDTO> buildDishDTOList(List<Dish> dList) {
		if (dList == null || dList.isEmpty()) {
			return null;
		}

		List<DishDTO> ret = new ArrayList<>();
		for (Dish c : dList) {
			ret.add(this.buildDishDTO(c));
		}

		return ret;
	}

}
