package rco.restapi.model;

import java.sql.ResultSet;

public abstract class ExtenderMySQLModel <T>
{
	public abstract String GetDatabaseTableName();
	public abstract T MapToModel(ResultSet resultSet);
}