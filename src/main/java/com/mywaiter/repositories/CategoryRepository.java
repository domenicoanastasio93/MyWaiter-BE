package com.mywaiter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mywaiter.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query("SELECT c FROM Category c ORDER BY c.order, c.nameEn")
	public List<Category> findAllOrdered();

}
