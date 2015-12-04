package com.codingz.simplebook.idao;

import java.util.List;

import com.codingz.simplebook.model.Statusb;


public interface IStatusbDAO {
	public Statusb findById(Long id)throws Exception;
	public List<Statusb> findAll()throws Exception;
	public boolean save(Statusb statusb)throws Exception;

}
