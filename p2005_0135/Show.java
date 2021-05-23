package p2005_0135;

import java.util.Scanner;

public class Show {

	private String name;
	private int timesWatched = 0;
	private double rate = 0;
	private static int maxRate = 5;
	
	public Show() {
		System.out.print("Please enter the Show name: ");
		Scanner scanner = new Scanner(System.in);
		this.name= scanner.nextLine().strip();
	}

	public Show(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTimesWatched() {
		return timesWatched;
	}

	public double getRate() {
		return rate;
	}

	public static int getMaxRate() {
		return maxRate;
	}

	public static void main(String[] args) {
		Show show = new Show();
	}
	
	public void updateRate() {
		Scanner scanner = new Scanner(System.in);
		int enteredRate;
		while (true) {
			System.out.printf("Please rate the show(0 to %d): ",this.maxRate);
			enteredRate = scanner.nextInt();
			if (enteredRate>=0 && enteredRate<=this.maxRate) {
				break;
			}
			System.out.print("INVAILID! reenter: ");
		}
		this.timesWatched++;
		this.rate = (	this.rate + enteredRate)/this.timesWatched;
	}
	
	@Override
	public String toString() {
		return this.name+"--"+this.rate+"--"+this.timesWatched;
	}
}
