package q1;

import java.util.Scanner;

public class GoldenClient {
	private static int gldNo = 0;
	private String ID, Name;
	private double balance;

	public GoldenClient(String iD, String name, double balance) {
		ID = iD;
		Name = name;
		this.balance = balance > 0 ? balance : 0.0;
		gldNo++; // i think this will be increased every time we create normalClient object
	}

	protected static int getGldNo() {
		return gldNo;
	}

	protected static void setGldNo(int normNo) {
		GoldenClient.gldNo = normNo;
	}

	protected String getID() {
		return ID;
	}

	protected void setID(String iD) {
		ID = iD;
	}

	protected String getName() {
		return Name;
	}

	protected void setName(String name) {
		Name = name;
	}

	protected double getBalance() {
		return balance;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}

	public void deposit(double fund) {
		if (fund < 0) {
			System.out.println("you can not deposit negatively.");
			return;
		}
		this.balance += fund;
		System.out.println("Account is deposited with " + fund + " money. New Balance: " + balance);
	}

	public void debit(double fund) {
		boolean anyProblem = false; // will tell if user entered vailid(false) input or not(true)
		if (fund < 0) {
			System.out.println("Can not debit negative fund.");
			anyProblem = true;
		} else if (fund > 5000) {
			System.out.println("The debited amount exceeds linit 5000.");
			anyProblem = true;
		} else if (this.balance - fund < 0) {
			System.out.println("The debited amount exceeds acount balance.");
			anyProblem = true;
		}

		// ask to enter again
		if (anyProblem) {
			System.out.println("Enter another amount to debit (or 0 to cancel): ");
			Scanner scanner = new Scanner(System.in); // do not close the scanner , will create problems otherwise,
														// sideefect
			double fund1 = scanner.nextDouble();
			if (fund1 == 0)
				return;
			debit(fund1);
		} else {
			this.balance -= fund;
			System.out.println("Account is debited with " + fund + " money. New Balance: " + balance);
		}
	}

	public double transfer(double amount) { // or transFeeAction
		double transferedAmount = this.balance - amount;
		if (transferedAmount < 0) {
			System.out.println("Amount exceeded account balance.");
			return 0;
		}
		return transferedAmount;
	}
}
