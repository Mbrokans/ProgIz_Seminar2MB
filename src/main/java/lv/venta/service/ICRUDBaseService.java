package lv.venta.service;

import java.util.ArrayList;

public interface ICRUDBaseService<Ttype> {
	//retrieve all, retrieve by id
	
	public abstract ArrayList<Ttype> retrieveAll() throws Exception;
	
	public abstract Ttype retrieveById(long id)throws Exception;
	
	public abstract void deleteById(long id) throws Exception;
	
	public abstract void create(Ttype newObject) throws Exception;
}
