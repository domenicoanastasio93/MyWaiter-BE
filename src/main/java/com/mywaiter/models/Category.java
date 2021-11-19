package com.mywaiter.models;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

@Entity(name = "Category")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "id", "nameEn", "nameIt" }))
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private Integer id;

	@Basic(optional = false)
	private String nameEn;

	@Basic(optional = false)
	private String nameIt;

	@Basic(optional = false)
	private Integer order;

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Basic(optional = true)
	private String additiveNotesEn;

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Basic(optional = true)
	private String additiveNotesIt;

	@Basic(optional = false)
	private Timestamp creationDate;

	@Basic(optional = false)
	private Timestamp updateDate;

	public Category() {
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
