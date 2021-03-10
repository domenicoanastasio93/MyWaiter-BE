package com.mywaiter.dto;

import java.sql.Timestamp;

public class CategoryDTO {

	private Integer id;
	private String nameEn;
	private String nameIt;
	private Integer order;
	private String additiveNotesEn;
	private String additiveNotesIt;
	private Timestamp creationDate;
	private Timestamp updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameIt() {
		return nameIt;
	}

	public void setNameIt(String nameIt) {
		this.nameIt = nameIt;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getAdditiveNotesEn() {
		return additiveNotesEn;
	}

	public void setAdditiveNotesEn(String additiveNotesEn) {
		this.additiveNotesEn = additiveNotesEn;
	}

	public String getAdditiveNotesIt() {
		return additiveNotesIt;
	}

	public void setAdditiveNotesIt(String additiveNotesIt) {
		this.additiveNotesIt = additiveNotesIt;
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

}
