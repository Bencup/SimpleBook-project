package com.codingz.simplebook.model;

import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.codingz.simplebook.model.Statusb;
import com.codingz.simplebook.model.Type;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String book_name;
	private int book_year;
	private String book_detail;
	private String author_name;
	/*private int book_total;*/

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id", nullable = true)
	private Type type;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="statusb_id",nullable = true)
	private Statusb statusb;
	
		
	public Statusb getStatusb() {
		return statusb;
	}

	public void setStatusb(Statusb statusb) {
		this.statusb = statusb;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public int getBook_year() {
		return book_year;
	}

	public void setBook_year(int book_year) {
		this.book_year = book_year;
	}

	public String getBook_detail() {
		return book_detail;
	}

	public void setBook_detail(String book_detail) {
		this.book_detail = book_detail;
	}

	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	
	
}
