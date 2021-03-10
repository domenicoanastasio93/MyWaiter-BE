package com.mywaiter.builders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mywaiter.dto.CategoryDTO;
import com.mywaiter.models.Category;

@Service
public class CategoryBuilder {

	public CategoryDTO buildCategoryDTO(Category c) {
		if (c == null) {
			return null;
		}

		CategoryDTO ret = new CategoryDTO();
		ret.setId(c.getId());
		ret.setNameEn(c.getNameEn());
		ret.setNameIt(c.getNameIt());
		ret.setOrder(c.getOrder());
		ret.setAdditiveNotesEn(c.getAdditiveNotesEn());
		ret.setAdditiveNotesIt(c.getAdditiveNotesIt());
		ret.setCreationDate(c.getCreationDate());
		ret.setUpdateDate(c.getUpdateDate());
		return ret;
	}

	public List<CategoryDTO> buildCategoryDTOList(List<Category> cList) {
		if (cList == null || cList.isEmpty()) {
			return null;
		}

		List<CategoryDTO> ret = new ArrayList<>();
		for (Category c : cList) {
			ret.add(this.buildCategoryDTO(c));
		}

		return ret;
	}

}
