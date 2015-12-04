package com.codingz.simplebook.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingz.simplebook.dao.StatusbDAO;
import com.codingz.simplebook.iservice.IStatusbService;
import com.codingz.simplebook.model.Statusb;

@Service
@Transactional
public class StatusbService implements IStatusbService {
	
	@Autowired
	private StatusbDAO statusbDAO;

	@Override
	public Statusb findById(Long id) throws Exception {
		return statusbDAO.findById(id);
	}

	@Override
	public List<Statusb> findAll() throws Exception {
		return statusbDAO.findAll();
	}

	@Override
	public boolean save(Statusb statusb) throws Exception {
		return statusbDAO.save(statusb);
	}

}
