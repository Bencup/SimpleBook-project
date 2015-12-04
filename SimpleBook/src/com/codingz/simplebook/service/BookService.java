package com.codingz.simplebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingz.simplebook.idao.IBookDAO;
import com.codingz.simplebook.iservice.IBookService;
import com.codingz.simplebook.model.Book;

@Service
@Transactional
public class BookService implements IBookService {
	
	@Autowired
	private IBookDAO bookDAO;
			
	@Override
	public Book findById(Long id) throws Exception {
		return bookDAO.findById(id);
	}

	@Override
	public List<Book> findAll() throws Exception {
		return bookDAO.findAll();
	}

	@Override
	public boolean save(Book book) throws Exception {
		return bookDAO.save(book);
	}

	@Override
	public boolean update(Book book) throws Exception {
		return bookDAO.update(book);
	}

	@Override
	public boolean delete(Book book) throws Exception {
		return bookDAO.delete(book);
	}

}
