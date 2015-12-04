package com.codingz.simplebook.idao;

import java.util.List;



import com.codingz.simplebook.model.Role;


public interface IRoleDAO {
	
	public Role findById(Long id)throws Exception;
	public List<Role> findAll()throws Exception;
	public boolean save(Role role)throws Exception;
	public boolean update(Role role)throws Exception;
	public boolean delete(Role role)throws Exception;

}
