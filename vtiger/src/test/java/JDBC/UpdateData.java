package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class UpdateData {

	public static void main(String[] args) throws SQLException {
	
Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql/vtiger", "root", "root");
		
		//executeupdate is used for Non-Select Query
	    int result = connection.createStatement().executeUpdate("insert into values('minit','singh','TCS');");
        if(result == 1)
        {
        	System.out.println("Database has been updated");
        }
        else
        {	System.out.println("Dtabase has not been updated");
        }	
        connection.close;
	
	}
	
}
