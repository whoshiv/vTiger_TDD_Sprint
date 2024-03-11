package vtiger.genericUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class DataBaseUtility {

	public String fetchDataFromDataBase(Connection connection, String query, int index) throws SQLException
	{
		ResultSet result = connection.createStatement().executeQuery(query);
		if(result.next())
		{
			return result.getString(index);
		}
		return "";
	}
	
	public void updateDataToDataBase(Connection connection, String query) throws SQLException
	{
		 int result = connection.createStatement().executeUpdate(query);
	        if(result == 1)
	        {
	        	System.out.println("Database has been updated");
	        }
	        else
	        {	System.out.println("Dtabase has not been updated");
	        }	
	}
}

