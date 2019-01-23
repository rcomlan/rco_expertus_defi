package rco.restapi.controller;

import rco.restapi.model.MySQLConnection;
import rco.restapi.repository.RepositoryFactory;

public class BaseController 
{
	
	protected MySQLConnection _MySQLConnection;
	protected RepositoryFactory _repositoryFactory;
	
	public BaseController()
	{
		this._MySQLConnection = new MySQLConnection();
		this._repositoryFactory = new RepositoryFactory(this._MySQLConnection);
	}

}
