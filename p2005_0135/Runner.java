package p2005_0135;

public class Runner {

	public static void main(String[] args) {
		System.out.println("FOR MOVIE 1: ");
		Movie movie1 = new Movie();
		Movie movie2 = new Movie("Interstellar", 169, 2014);

		System.out.println("FOR SERIES 1: ");
		Series series1 = new Series();
		Series series2 = new Series("Mars", 13, 60);

		
		System.out.println("CALLING TOSTRINGS ");
		System.out.println("FOR MOVIE 1:\n" + movie1 + "\n");
		System.out.println("FOR MOVIE 2:\n" + movie2 + "\n");
		System.out.println("FOR SERiES 1:\n" + series1 + "\n");
		System.out.println("FOR SERiES 2:\n" + series2 + "\n");
		
		//below queries were not asked in question:
		//feel free to delete the following code:
		System.out.println("UPDATING MOVIE RATE FOR MOVIE 1");
		movie1.updateRate();
		movie1.updateRate();
		movie1.updateRate();
		
		System.out.println("AFTER UPDATING RATINGS FOR MOVIE 1");
		System.out.println("FOR MOVIE 1:\n" + movie1 + "\n");

	}

}
