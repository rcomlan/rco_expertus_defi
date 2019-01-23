package rco.restapi.repository;

import java.util.List;

public interface IRepository <T> {
		
	//T Get(int id);
	List<T> GetAll();
		

}
