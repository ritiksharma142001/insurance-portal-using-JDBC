package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Helper.policyHelper;
import Model.Policy;

public class policyDAO {
	
	public boolean insert(Policy pol) {
		boolean isInserted = false;
		
		String insert = "insert into POLICY values(?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement prestate = policyHelper.getConnectionPreparedStatement(insert);
			
			prestate.setInt(1, pol.getId());
			prestate.setInt(2, pol.getcId());
			prestate.setString(3, pol.getType());
			prestate.setString(4, pol.getTitle());
			prestate.setString(5, pol.getStart());
			prestate.setInt(6, pol.getTerm());
			prestate.setLong(7, pol.getPremium());
			prestate.setLong(8, pol.getSum());
			
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

	public boolean update(Policy pol, int id,String tipe) {
		
		boolean isUpdated = false;
		String update = "update POLICY set ptype= ? where id = ?";
		
		try {
			
			PreparedStatement prestate = policyHelper.getConnectionPreparedStatement(update);
			prestate.setInt(2, pol.getId());
			prestate.setString(1, tipe);
			
			int numberOfRecordsEffected = prestate.executeUpdate();
			if(numberOfRecordsEffected >=1) {
				isUpdated = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isUpdated;
		
	}
	
	public boolean updateTitle(Policy pol, int id,String tile) {
		
		boolean isUpdated = false;
		String update = "update POLICY set title= ? where id = ?";
		
		try {
			
			PreparedStatement prestate = policyHelper.getConnectionPreparedStatement(update);
			prestate.setInt(2, pol.getId());
			prestate.setString(1, tile);
			
			int numberOfRecordsEffected = prestate.executeUpdate();
			if(numberOfRecordsEffected >=1) {
				isUpdated = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isUpdated;
		
	}

	public boolean delete(int id) {
		boolean isDelete = false;
		
		String delete = "delete from POLICY where id = ? ";
		
		try {
			
			PreparedStatement prestate = policyHelper.getConnectionPreparedStatement(delete);
			
			prestate.setInt(1,id);
			int numberOfRecordsEffected = prestate.executeUpdate();
			if(numberOfRecordsEffected >=1) {
				isDelete = true;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isDelete;
	}

	public ArrayList<Policy> get(int cust_id) {
		ArrayList<Policy> pol = new ArrayList<Policy>();
		String sql = "select * from POLICY where custId = ? ";
		try {
			
			PreparedStatement prestate = policyHelper.getConnectionPreparedStatement(sql);
			prestate.setInt(1, cust_id);
			
			ResultSet rs = prestate.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String type = rs.getString("ptype");
				String title = rs.getString("title");
				String start = rs.getString("start");
				int term = rs.getInt("term");
				long premium = rs.getLong("premium");
				long sum = rs.getLong("sum_assured");
				
				Policy temp = new Policy(id,cust_id,type,title,start, term,premium,sum);
				pol.add(temp);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pol;
	}
	
	public Policy getone(int pid,int cust_id) {
		ArrayList<Policy> pol = new ArrayList<Policy>();
		String sql = "select * from POLICY where custId = ? ";
		try {
			
			PreparedStatement prestate = policyHelper.getConnectionPreparedStatement(sql);
			prestate.setInt(1, cust_id);
			
			ResultSet rs = prestate.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String type = rs.getString("ptype");
				String title = rs.getString("title");
				String start = rs.getString("start");
				int term = rs.getInt("term");
				long premium = rs.getLong("premium");
				long sum = rs.getLong("sum_assured");
				
				Policy temp = new Policy(id,cust_id,type,title,start, term,premium,sum);
				pol.add(temp);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Policy p:pol) {
			if(p.getId() == pid) {
				return p;
			}
		}
		return null;
	}

	public ArrayList<Policy> getAll() {
		ArrayList<Policy> pol = new ArrayList<Policy>();
		String sql = "select * from POLICY ";
		try {
			
			PreparedStatement prestate = policyHelper.getConnectionPreparedStatement(sql);
			
			ResultSet rs = prestate.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int cid = rs.getInt("custid");
				String type = rs.getString("ptype");
				String title = rs.getString("title");
				String start = rs.getString("start");
				int term = rs.getInt("term");
				long premium = rs.getLong("premium");
				long sum = rs.getLong("sum_assured");
				
				Policy temp = new Policy(id,cid,type,title,start,term,premium,sum);
				pol.add(temp);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pol;
	}
}
