package com.info.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection connection;
	public static Connection createConnection()
	{
		try{
			//String driver="oracle.jdbc.OracleDriver";
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/db2?verifyServerCertificate=false&useSSL=true";
			String username="root";
			String password = "sql123";
		    connection= DriverManager.getConnection(url,username,password);				
		}
		catch(ClassNotFoundException cnf){
			System.out.println("Jar problem...");
			cnf.printStackTrace();
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		return connection;
	}

}
