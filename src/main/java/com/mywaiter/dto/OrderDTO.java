package com.mywaiter.dto;

import java.sql.Timestamp;
import java.util.List;

public class OrderDTO {

	private Integer id;
	private Integer table;
	private List<OrderItem> orderList;
	private String additiveNotes;
	private Timestamp creationDate;
	private Timestamp updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTable() {
		return table;
	}

	public void setTable(Integer table) {
		this.table = table;
	}

	public List<OrderItem> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderItem> orderList) {
		this.orderList = orderList;
	}

	public String getAdditiveNotes() {
		return additiveNotes;
	}

	public void setAdditiveNotes(String additiveNotes) {
		this.additiveNotes = additiveNotes;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public static class OrderItem {
		public String categoryId;
		public List<DishDTO> dishes;

		public String getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(String categoryId) {
			this.categoryId = categoryId;
		}

		public List<DishDTO> getDishes() {
			return dishes;
		}

		public void setDishes(List<DishDTO> dishes) {
			this.dishes = dishes;
		}

	}

}
