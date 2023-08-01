package Helper;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class customerHelper {
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement pstatement;
	
	public static Statement getConnectionStatement() throws SQLException {
		
//		customerHelper.connection = DriverManager.getConnection("jdbc:derby:Insurance;create=true");
		customerHelper.connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Insurance;create=true");
		customerHelper.statement = connection.createStatement();
		
		return statement;
	
	}
	
	public static PreparedStatement getConnectionPreparedStatement(String sql) throws SQLException {
		
		customerHelper.connection = DriverManager.getConnection("jdbc:derby:Insurance;create=true");
		customerHelper.pstatement = connection.prepareStatement(sql);
		
		return pstatement;
	}
	
	public static void closeStatement() throws SQLException {
		customerHelper.statement.close();
		customerHelper.connection.close();
	}
	
	public static void closePreparedStatement() throws SQLException {
		customerHelper.pstatement.close();
		customerHelper.connection.close();
	}
}
