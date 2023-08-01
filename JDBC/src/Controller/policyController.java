package Controller;

import java.util.ArrayList;

import DAO.policyDAO;
import Model.Policy;

public class policyController {
	private policyDAO pdao;
	
	public policyController() {
		this.pdao = new policyDAO();
	}

	public boolean insert(Policy pol) {
		return this.pdao.insert(pol);
	}

	public boolean update(Policy pol,int id,String tipe) {
		return this.pdao.update(pol,id,tipe);
	}
	
	public boolean updateTitle(Policy pol,int id,String tipe) {
		return this.pdao.update(pol,id,tipe);
	}
	
	public boolean delete(int id) {
		return this.pdao.delete(id);
	}
	
	public Policy getone(int pid, int cid) {
		return this.pdao.getone(pid,cid);
	}
	
	public ArrayList<Policy> get(int id) {
		return this.pdao.get(id);
	}
	
	public ArrayList<Policy> getAll() {
		return this.pdao.getAll();
	}
}
