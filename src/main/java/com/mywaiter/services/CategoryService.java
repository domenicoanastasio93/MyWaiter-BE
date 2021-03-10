package com.mywaiter.services;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywaiter.dto.CategoryDTO;
import com.mywaiter.models.Category;
import com.mywaiter.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category createOrEditCategory(CategoryDTO body) throws Exception {
		Category ret = null;
		boolean isCreation = false;
		if (body.getId() == null) {
			ret = new Category();
			isCreation = true;
		} else {
			ret = this.retrieveById(body.getId());
		}

		if (body.getNameEn() != null && body.getNameEn() != "") {
			ret.setNameEn(body.getNameEn());
		} else {
			if (isCreation) {
				throw new Exception("nameEn is null");
			}
		}
		if (body.getOrder() != null) {
			ret.setOrder(body.getOrder());
		}
		if (body.getAdditiveNotesEn() != null && body.getAdditiveNotesEn() != "") {
			ret.setAdditiveNotesEn(body.getAdditiveNotesEn());
		} else {
			if (isCreation) {
				throw new Exception("additiveNotesEn is null");
			}
		}
		if (body.getAdditiveNotesIt() != null && body.getAdditiveNotesIt() != "") {
			ret.setAdditiveNotesIt(body.getAdditiveNotesIt());
		} else {
			if (isCreation) {
				throw new Exception("additiveNotesIt is null");
			}
		}

		if (!isCreation) {
			Timestamp now = Timestamp.from(Instant.now());
			ret.setUpdateDate(now);
		}

		ret = categoryRepository.saveAndFlush(ret);
		return ret;
	}

	public List<Category> retrieveAllCategories() {
		List<Category> ret = categoryRepository.findAllOrdered();
		return ret;
	}

	public Category retrieveById(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("id is null");
		}
		Optional<Category> optC = categoryRepository.findById(id);
		if (optC.isEmpty()) {
			throw new Exception("category is null for id: " + id);
		}
		return optC.get();
	}

}
