package Helper;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class policyHelper {
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement pstatement;
	
	public static Statement getConnectionStatement() throws SQLException {
		
		policyHelper.connection = DriverManager.getConnection("jdbc:derby:Insurance;create=true");
		policyHelper.statement = connection.createStatement();
		
		return statement;
	
	}
	
	public static PreparedStatement getConnectionPreparedStatement(String sql) throws SQLException {
		
		policyHelper.connection = DriverManager.getConnection("jdbc:derby:Insurance;create=true");
//		policyHelper.connection = DriverManager.getConnection("jdbc:derby:C:\\Users\\sakku\\eclipse-workspace\\JDBC\\Insurance;create=true");
		policyHelper.pstatement = connection.prepareStatement(sql);
		
		return pstatement;
	}
	
	public static void closeStatement() throws SQLException {
		policyHelper.statement.close();
		policyHelper.connection.close();
	}
	
	public static void closePreparedStatement() throws SQLException {
		policyHelper.pstatement.close();
		policyHelper.connection.close();
	}
}
