package com.codingz.simplebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingz.simplebook.idao.ITypeDAO;
import com.codingz.simplebook.iservice.ITypeService;
import com.codingz.simplebook.model.Type;

@Service
@Transactional
public class TypeService implements ITypeService {
	
	@Autowired
	private ITypeDAO typeDAO;

	@Override
	public Type findById(Long id) throws Exception {
		return typeDAO.findById(id);
	}

	@Override
	public List<Type> findAll() throws Exception {
		return typeDAO.findAll();
	}

	@Override
	public boolean save(Type type) throws Exception {
		return typeDAO.save(type);
	}

}
