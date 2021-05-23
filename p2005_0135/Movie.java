package p2005_0135;

import java.util.Scanner;

public class Movie extends Show {
	private int duration;
	private int productionYear;

	public Movie() {
		super();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the Movie duration: ");
		this.duration = scanner.nextInt();
		System.out.print("Please enter the productionYear: ");
		this.productionYear = scanner.nextInt();
	}

	public Movie(String name, int duration, int productionYear) {
		super(name);
		this.duration = duration;
		this.productionYear = productionYear;
	}
	
	public int getDuration() {
		return duration;
	}

	public int getProductionYear() {
		return productionYear;
	}

	@Override
	public String toString() {
		return super.toString()+"\n"+this.duration+"--"+this.productionYear;
	}	
}
