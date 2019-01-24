package rco.springmvc.dao;

import java.sql.Blob;

public interface JobApplicationDAO 
{
	void addJobApplication(String username, String refjob, String availability_date, Blob resume);
}
