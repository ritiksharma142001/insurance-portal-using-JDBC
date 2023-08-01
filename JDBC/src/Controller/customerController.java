package Controller;

import DAO.customerDAO;
import Model.Customer;

public class customerController {

	private customerDAO cdao;
	
	public customerController() {
		this.cdao = new customerDAO();
	}

	public boolean insert(Customer cust) {
		return this.cdao.insert(cust);
	}

	/*
	 * public boolean update(Customer cust,int id,String email) { return
	 * this.cdao.update(cust, id,email); }
	 */
	
	public boolean isPresent(int id) {
		return this.cdao.isPresent(id);
	}
	
	public boolean isCorrect(int id, String pass) {
		return this.cdao.isCorrect(id, pass);
	}
	
	/*
	 * public Customer getone(int id) { return this.cdao.getone(id); }
	 */
}
