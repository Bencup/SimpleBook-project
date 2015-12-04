package com.codingz.simplebook.idao;

import java.util.List;

import com.codingz.simplebook.model.Borrow;

public interface IBorrowDAO {
	
	public Borrow findById(Long id)throws Exception;
	public List<Borrow> findAll()throws Exception;
	public boolean save(Borrow borrow)throws Exception;
	public boolean update(Borrow borrow)throws Exception;
	public boolean delete(Borrow borrow)throws Exception;
	public List<Borrow> findBorrowByUserId(Long userId)throws Exception;

}
