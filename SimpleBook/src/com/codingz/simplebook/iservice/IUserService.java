package com.codingz.simplebook.iservice;

import java.util.List;



import com.codingz.simplebook.model.User;

public interface IUserService {
	
	public User findById(Long id)throws Exception;
	public List<User> findAll()throws Exception;
	public boolean save(User user)throws Exception;
	public boolean update(User user)throws Exception;
	public boolean delete(User user)throws Exception;
	public User findByUsername(String username)throws Exception;

}
