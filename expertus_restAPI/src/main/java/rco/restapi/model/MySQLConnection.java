package rco.restapi.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe permettant de faire le appels à la base de données MySQL
 * @author Romaric Comlan
 *
 */
public class MySQLConnection 
{
	//REQUIREMENTS
	
	private static Connection connection;
	
	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private String DATABASE_URL = " ";
	
	//  Database credentials
	private String USER = " ";
	private String PASSWORD = " ";

	/**
	 * Constructeur par default permettant de ce connecter à une base de données
	 */
	public MySQLConnection()
	{
		try
	    {
	    	String filePath = "C:\\Users\\dell\\eclipse-workspace\\expertus_webapp\\Parameters.conf";
	    	try 
	    	{
                // Création du flux bufférisé sur un FileReader, immédiatement suivi par un
                // try/finally, ce qui permet de ne fermer le flux QUE s'il le reader
                // est correctement instancié (évite les NullPointerException)
                BufferedReader buff = new BufferedReader(new FileReader(filePath));
                try 
                {
                    String line;
                    while ((line = buff.readLine()) != null) 
                    {
                        if (line.startsWith("User :")) 
                        {
                            USER = line.substring(6);
                        }
                        else if (line.startsWith("Password :")) 
                        {
                            PASSWORD = line.substring(10);
                        }
                        else if (line.startsWith("mySQL Address :")) 
                        {
                            String mySQLAdresse = line.substring(15);
                            DATABASE_URL = "jdbc:mysql://" + mySQLAdresse + "/expertus_database";
                            break;
                        }
                    }
                } 
                finally 
                {
                    buff.close();
                }
            } 
	    	catch (IOException ioe) 
	    	{
                ioe.printStackTrace();
            }
	    	
	    	//STEP 2: Register JDBC driver
	    	Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
	    }
	    catch (ClassNotFoundException e) {}
	    catch (SQLException e) {}
	  }
	
	/**
	 * Return the instance or create if not exists
	 * @return
	 */
	public static Connection getInstance()
	{
		if(connection == null)
		{
			new MySQLConnection();
		}
		return connection;
	}	
}
