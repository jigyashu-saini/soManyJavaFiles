package q2;

// this class will have the information of the player like his/her name and balance;
public class Player {
	private String name;
	private double balance;
	
	public Player() {
		this("");
	}
	
	public Player(String name) {
		this.name = name;
		this.balance = 0; //initializing balance to 0
	}

	protected double getBalance() {
		return balance;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}

	protected String getName() {
		return name;
	}
}
