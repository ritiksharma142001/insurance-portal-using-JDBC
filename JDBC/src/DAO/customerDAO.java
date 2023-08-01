package DAO;

import Helper.customerHelper;
import Helper.policyHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Customer;

public class customerDAO {
	
	public boolean insert(Customer cust) {
		boolean isInserted = false;
		
		String insert = "insert into CUSTOMER values(?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement prestate = customerHelper.getConnectionPreparedStatement(insert);
			
			prestate.setInt(1, cust.get_id());
			prestate.setString(2, cust.get_name());
			prestate.setString(3, cust.get_email());
			prestate.setString(4, cust.get_pass());
			prestate.setString(5, cust.get_address());
			prestate.setString(6, cust.get_contact());
			prestate.setString(7, cust.get_nominee());
			prestate.setString(8,cust.get_relation());
			
			
			int numberOfRecordsEffected = prestate.executeUpdate();
			if(numberOfRecordsEffected >=1) {
				isInserted = true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isInserted;
	}
	
	public boolean isPresent(int id) {
		boolean present = false;
		String sql = "select * from CUSTOMER where id = ?"; 
		try {
			PreparedStatement prestate = policyHelper.getConnectionPreparedStatement(sql);
			prestate.setInt(1, id);
			
			ResultSet rs = prestate.executeQuery();
			if(rs.next()) {
				present = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return present;
	}
	
	public boolean isCorrect( int id,String pass) {
		boolean present = false;
		String sql = "select PASS,id from CUSTOMER where id = ?"; 
		try {
			PreparedStatement prestate = policyHelper.getConnectionPreparedStatement(sql);
			prestate.setInt(1, id);
			
			ResultSet rs = prestate.executeQuery();
			while(rs.next()) {
															//System.out.println("*"+rs.getString("pass") + rs.getInt("id"));
				String p = rs.getString("pass").replaceAll("\\s+","");
															//System.out.println(p==pass);
															//System.out.println(id == rs.getInt("id"));
				if(pass.equals(p) && id == rs.getInt("id")) {
															//System.out.println(present);
					present = true;
															//System.out.println(present);
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return present;
	}

	
}
