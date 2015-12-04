package com.codingz.simplebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingz.simplebook.idao.IRoleDAO;
import com.codingz.simplebook.iservice.IRoleService;
import com.codingz.simplebook.model.Role;

@Service
@Transactional
public class RoleService implements IRoleService {
	
	@Autowired
	private IRoleDAO roleDAO;

	@Override
	public Role findById(Long id) throws Exception {
		return roleDAO.findById(id);
	}

	@Override
	public List<Role> findAll() throws Exception {
		return roleDAO.findAll();
	}

	@Override
	public boolean save(Role role) throws Exception {
		return roleDAO.save(role);
	}

	@Override
	public boolean update(Role role) throws Exception {
		return roleDAO.update(role);
	}

	@Override
	public boolean delete(Role role) throws Exception {
		return roleDAO.delete(role);
	}

}
