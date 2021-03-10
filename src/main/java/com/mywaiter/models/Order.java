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

@Entity(name = "Order")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private Integer id;

	@Basic(optional = false)
	private Integer table;

	@Lob
	@Basic(optional = false)
	private String jsonOrderList;

	@Lob
	@Basic(optional = true)
	private String additiveNotes;

	@Basic(optional = false)
	private Timestamp creationDate;

	@Basic(optional = false)
	private Timestamp updateDate;

	public Order() {
		Timestamp now = Timestamp.from(Instant.now());
		creationDate = now;
		updateDate = now;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJsonOrderList() {
		return jsonOrderList;
	}

	public void setJsonOrderList(String jsonOrderList) {
		this.jsonOrderList = jsonOrderList;
	}

	public Integer getTable() {
		return table;
	}

	public void setTable(Integer table) {
		this.table = table;
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

}
