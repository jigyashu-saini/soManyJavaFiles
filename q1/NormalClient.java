package q1;

import java.util.Scanner;

public class NormalClient {
	private static int normNo = 0;
	private String ID, Name;
	private double balance;
	private final double fee = 2.5; // or its transFee in UML but in description it is simply fee

	public NormalClient(String iD, String name, double balance) {
		ID = iD;
		Name = name;
		this.balance = balance > 0 ? balance : 0.0;
		normNo++; // i think this will be increased every time we create normalClient object
	}

	protected static int getNormNo() {
		return normNo;
	}

	protected static void setNormNo(int normNo) {
		NormalClient.normNo = normNo;
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

	protected double getTransFee() {
		return fee;
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
		boolean anyProblem = false; // will tell if user entered vailid input or not
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

	public double transFee(double amount) { // or transFeeAction
		double transferedAmount = this.balance - amount - fee;
		if (transferedAmount < 0) {
			System.out.println("Amount exceeded account balance.");
			return 0;
		}
		return transferedAmount;
	}

}
