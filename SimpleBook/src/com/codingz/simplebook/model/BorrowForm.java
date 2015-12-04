package com.codingz.simplebook.model;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;



public class BorrowForm {
	
	private Long id;
	
	private String dateBorrow;	
	
	private String dateLimit;
	
	private String dateReturn;

	private String test;
	
	
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDateBorrow() {
		return dateBorrow;
	}

	public void setDateBorrow(String dateBorrow) {
		this.dateBorrow = dateBorrow;
	}

	public String getDateLimit() {
		return dateLimit;
	}

	public void setDateLimit(String dateLimit) {
		this.dateLimit = dateLimit;
	}
	
	
	public String getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(String dateReturn) {
		this.dateReturn = dateReturn;
	}

	@Override
	public String toString() {
		return "BorrowForm [id=" + id + ", dateBorrow=" + dateBorrow
				+ ", dateLimit=" + dateLimit + ", dateReturn=" + dateReturn
				+ ", test=" + test + "]";
	}
	
	
}
