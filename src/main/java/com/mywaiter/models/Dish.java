package com.mywaiter.models;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

@Entity(name = "Dish")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "id", "name" }))
public class Dish {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private Integer id;

	@Basic(optional = false)
	@ManyToOne
	private Category category;

	@Basic(optional = false)
	private String name;

	@Basic(optional = false)
	private Integer order;

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Basic(optional = true)
	private String descriptionEn;

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Basic(optional = true)
	private String descriptionIt;

	@Basic(optional = false)
	private Float price;

	@Basic(optional = false)
	private Timestamp creationDate;

	@Basic(optional = false)
	private Timestamp updateDate;

	public Dish() {
		Timestamp now = Timestamp.from(Instant.now());
		creationDate = now;
		updateDate = now;
		order = 1;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	public String getDescriptionIt() {
		return descriptionIt;
	}

	public void setDescriptionIt(String descriptionIt) {
		this.descriptionIt = descriptionIt;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
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
