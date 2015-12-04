package com.codingz.simplebook.idao;

import java.util.List;

import com.codingz.simplebook.model.Type;

public interface ITypeDAO {
	
	public Type findById(Long id)throws Exception;
	public List<Type> findAll()throws Exception;
	public boolean save(Type type)throws Exception;
	
}
