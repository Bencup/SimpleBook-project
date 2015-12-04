package com.codingz.simplebook.iservice;

import java.util.List;

import com.codingz.simplebook.model.Type;

public interface ITypeService {
	
	public Type findById(Long id)throws Exception;
	public List<Type> findAll()throws Exception;
	public boolean save(Type type)throws Exception;

}
