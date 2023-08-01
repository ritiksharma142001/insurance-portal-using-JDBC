package Model;

public class Policy {
	private int cid;
	private int id;
	private String type;
	private String title;
	private String start;
	private int term;
	private long premium;
	private long sum;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getcId() {
		return cid;
	}
	public void setcId(int cid) {
		this.cid = cid;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	
	public long getPremium() {
		return premium;
	}
	public void setPremium(long premium) {
		this.premium = premium;
	}
	
	public long getSum() {
		return sum;
	}
	public void setSum(long sum) {
		this.sum = sum;
	}
	
	public Policy(int id,int cid, String type, String title, String start, int term, long premium, long sum) {
		super();
		this.id = id;
		this.cid = cid;
		this.type = type;
		this.title = title;
		this.start = start;
		this.term = term;
		this.premium = premium;
		this.sum = sum;
	}
	
	
	
}
