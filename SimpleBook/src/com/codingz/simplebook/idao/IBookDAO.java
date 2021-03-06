package com.codingz.simplebook.idao;

import java.util.List;

import com.codingz.simplebook.model.Book;

public interface IBookDAO {
	
	public Book findById(Long id)throws Exception;
	public List<Book> findAll()throws Exception;
	public boolean save(Book book)throws Exception;
	public boolean update(Book book)throws Exception;
	public boolean delete(Book book)throws Exception;
	

}
