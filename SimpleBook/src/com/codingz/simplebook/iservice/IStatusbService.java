package com.codingz.simplebook.iservice;

import java.util.List;

import com.codingz.simplebook.model.Statusb;


public interface IStatusbService {
	
	public Statusb findById(Long id)throws Exception;
	public List<Statusb> findAll()throws Exception;
	public boolean save(Statusb statusb)throws Exception;

}
