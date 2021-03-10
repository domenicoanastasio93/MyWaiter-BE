package com.mywaiter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywaiter.builders.CategoryBuilder;
import com.mywaiter.dto.CategoryDTO;
import com.mywaiter.models.Category;
import com.mywaiter.services.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryBuilder categoryBuilder;

	@GetMapping("{id}")
	public ResponseEntity<CategoryDTO> retrieveOrder(@PathVariable("id") Integer id) {
		ResponseEntity<CategoryDTO> ret = null;
		CategoryDTO cDTO = null;
		try {
			Category c = categoryService.retrieveById(id);
			cDTO = categoryBuilder.buildCategoryDTO(c);
			ret = new ResponseEntity<CategoryDTO>(cDTO, HttpStatus.OK);
		} catch (Exception ex) {
			ret = new ResponseEntity<CategoryDTO>(cDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ret;
	}

	@GetMapping
	public ResponseEntity<List<CategoryDTO>> retrieveAllCategories() {
		List<Category> oList = categoryService.retrieveAllCategories();
		List<CategoryDTO> oDTOList = categoryBuilder.buildCategoryDTOList(oList);
		ResponseEntity<List<CategoryDTO>> ret = new ResponseEntity<List<CategoryDTO>>(oDTOList, HttpStatus.OK);
		return ret;
	}
}
