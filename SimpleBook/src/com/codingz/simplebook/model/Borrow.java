package com.codingz.simplebook.model;


import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.codingz.simplebook.model.Book;
import com.codingz.simplebook.model.Statusb;
import com.codingz.simplebook.model.User;

@Entity
@Table(name="borrow")
public class Borrow {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id",nullable=true)
	private User user;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="book_id",nullable=true)
	private Book book;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="statusb_id",nullable=true)
	private Statusb statusb;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date_borrow;	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date_limit;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date_return;
	
	private int fine;
	
	
	
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	@Transient
	String test;
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private Date tmpDate;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Date getDate_borrow() {
		return date_borrow;
	}
	public void setDate_borrow(Date date_borrow) {
		this.date_borrow = date_borrow;
	}
	public Date getDate_limit() {
		return date_limit;
	}
	public void setDate_limit(Date date_limit) {
		this.date_limit = date_limit;
	}
	public Date getDate_return() {
		return date_return;
	}
	public void setDate_return(Date date_return) {
		this.date_return = date_return;
	}
	
public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	//	
//	public Date getTmpDate() {
//		return tmpDate;
//	}
//	public void setTmpDate(Date tmpDate) {
//		this.tmpDate = tmpDate;
//	}
	@Override
	public String toString() {
		return "Borrow [id=" + id + ", user=" + user + ", book=" + book
				+ ", statusb=" + statusb + ", date_borrow=" + date_borrow
				+ ", date_limit=" + date_limit + ", date_return=" + date_return
				+ "]";
	}
		
		

}
