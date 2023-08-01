package Model;

public class Customer {
	
	private int id;
	private String name;
	private String pass;
	private String email;
	private String address;
	private String contact;
	private String nominee;
	private String relation;
	
	public int get_id() {
		return id;
	}
	public void set_id(int id) {
		this.id=id;
	}
	
	public String get_name() {
		return name;
	}
	public void set_name(String name) {
		this.name=name;
	}
	
	public String get_pass() {
		return pass;
	}
	public void set_pass(String pass) {
		this.pass=pass;
	}
	
	public String get_email() {
		return email;
	}
	public void set_email(String email) {
		this.email=email;
	}
	
	public String get_address() {
		return address;
	}
	public void set_address(String address) {
		this.address=address;
	}
	
	public String get_contact() {
		return contact;
	}
	public void set_contact(String contact) {
		this.contact=contact;
	}
	
	public String get_nominee() {
		return nominee;
	}
	public void set_nominee(String nominee) {
		this.nominee=nominee;
	}
	
	public String get_relation() {
		return relation;
	}
	public void set_relation(String relation) {
		this.pass=relation;
	}
	
	public Customer(int id,String name,String pass, String email, String address, String contact, String nominee, String relation) {
		super();
		this.id = id;
		this.name=name;
		this.pass=pass;
		this.email=email;
		this.address=address;
		this.contact=contact;
		this.nominee=nominee;
		this.relation=relation;
		
	}
}
