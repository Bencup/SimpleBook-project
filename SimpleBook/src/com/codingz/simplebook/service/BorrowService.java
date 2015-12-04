package com.codingz.simplebook.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingz.simplebook.idao.IBorrowDAO;
import com.codingz.simplebook.iservice.IBorrowService;
import com.codingz.simplebook.model.Borrow;

@Service
@Transactional
public class BorrowService implements IBorrowService {
	
	@Autowired
	private IBorrowDAO borrowDAO;

	@Override
	public Borrow findById(Long id) throws Exception {
		
		
		return borrowDAO.findById(id);
	}

	@Override
	public List<Borrow> findAll() throws Exception {
		return borrowDAO.findAll();
	}

	@Override
	public boolean save(Borrow borrow) throws Exception {
		return borrowDAO.save(borrow);
	}

	@Override
	public boolean update(Borrow borrow) throws Exception {
		return borrowDAO.update(borrow);
	}

	@Override
	public boolean delete(Borrow borrow) throws Exception {
		return borrowDAO.delete(borrow);
	}

	@Override
	public List<Borrow> getListBorrowByUserId(Long userId) throws Exception {
		return borrowDAO.findBorrowByUserId(userId);
	}

}
