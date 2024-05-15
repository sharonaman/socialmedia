package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Databaseconnector {
	Connection con=null;
	public Connection connector()
	{

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}

}
