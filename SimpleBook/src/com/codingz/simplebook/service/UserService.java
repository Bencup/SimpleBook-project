package com.codingz.simplebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingz.simplebook.idao.IUserDAO;
import com.codingz.simplebook.iservice.IUserService;
import com.codingz.simplebook.model.User;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	@Override
	public User findById(Long id) throws Exception {
		return userDAO.findById(id);
	}

	@Override
	public List<User> findAll() throws Exception {
		return userDAO.findAll();
	}

	@Override
	public boolean save(User user) throws Exception {
		return userDAO.save(user);
	}

	@Override
	public boolean update(User user) throws Exception {
		return userDAO.update(user);
	}

	@Override
	public boolean delete(User user) throws Exception {
		return userDAO.delete(user);
	}

	@Override
	public User findByUsername(String username) throws Exception {
		return userDAO.findByUsername(username);
	}

}
