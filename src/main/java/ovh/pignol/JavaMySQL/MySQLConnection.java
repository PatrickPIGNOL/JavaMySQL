package ovh.pignol.JavaMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection implements AutoCloseable
{
	private Connection aConnection = null;
	
	public MySQLConnection(String pJDBCConnectionString, String pUserName, String pPassword) throws SQLException
	{
		this.aConnection = DriverManager.getConnection(pJDBCConnectionString, pUserName, pPassword);
	}
	
	public Connection mConnection()
	{
		return this.aConnection;
	}

	@Override
	public void close() throws Exception 
	{
		if(this.aConnection != null && !this.aConnection.isClosed())
		{
			this.aConnection.close();
		}
		this.aConnection = null;
	}
}
