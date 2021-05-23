package packageForAccountList;

public class node {
	public int account_number;
	public String name;
	public double balance;
	
	public node next;

	public node(int account_number, String name, double balance) {
		super();
		this.account_number = account_number;
		this.name = name;
		this.balance = balance;
		
		this.next = null;
	}
	
	
}
