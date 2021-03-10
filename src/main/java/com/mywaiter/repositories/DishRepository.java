package com.mywaiter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mywaiter.models.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

	@Query("SELECT d FROM Dish d WHERE d.category.id = :categoryId ORDER BY d.order, d.name")
	public List<Dish> findByCategoryIdOrdered(@Param("categoryId") Integer categoryId);

}
