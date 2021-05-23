import java.util.Random;
import java.util.Scanner;

public class stonePaperScissorsLizardSpockSivakumar {
	public static int findWinner(String s1, String s2) {
		int winner = 0;
		if (s1.equals("stone")) { // if player 1 chooses stone
			if (s2.equals("stone"))
				winner = 0;
			else if (s2.equals("scissors") || s2.equals("lizard"))
				winner = 1;
			else
				winner = 2;
		} else if (s1.equals("scissors")) { // if player 1 chooses scissors
			if (s2.equals("scissors"))
				winner = 0;
			else if (s2.equals("paper") || s2.equals("lizard"))
				winner = 1;
			else
				winner = 2;
		} else if (s1.equals("paper")) { // if player 1 chooses paper
			if (s2.equals("paper"))
				winner = 0;
			else if (s2.equals("stone") || s2.equals("spock"))
				winner = 1;
			else
				winner = 2;
		} else if (s1.equals("lizard")) {
			if (s2.equals("lizard"))
				winner = 0;
			else if (s2.equals("paper") || s2.equals("spock"))
				winner = 1;
			else
				winner = 2;
		} else { // spock
			if (s2.equals("spock"))
				winner = 0;
			else if (s2.equals("stone") || s2.equals("scissors"))
				winner = 1;
			else
				winner = 2;
		}
		return winner;
	}

	// method to return player2 choice
	public static String randomPlayer2Option() {
		String[] vailidPicks = { "stone", "paper", "scissors", "spock", "lizard" };
		Random random = new Random();
		// random.nextInt(max - min) + min;
		return vailidPicks[random.nextInt(4)]; // last index of array is 4
	}

	public static void main(String[] args) {
		Scanner pick = new Scanner(System.in);
		String s1 = ""; // s1 is player 1's choice string

		do {
			do {
				System.out.print("Player 1: Choose stone, scissors, paper, lizard or spock (Enter 'done' to exit): ");
				s1 = pick.next();
				s1 = s1.toLowerCase();
				String vailidPicks = "stone paper scissors spock lizard done";
				if (vailidPicks.contains(s1))
					break;
			} while (true); // input value until its not a vailid input

			if (s1.compareTo("done")==0) {
				break;
			}

			String s2 = randomPlayer2Option(); // s2 is player 2's choice string
			System.out.println("Player 2 has chosen: " + s2);

			int winner = findWinner(s1, s2);
			if (winner == 0) {
				System.out.println("It's a draw! You both chose the same object" + " which is: " + s1 + ".\n");
			} else {
				System.out.println("Player " + winner + " Wins.\n");
			}
		} while (true);

		System.out.println("EXITING_________ thanls for playing :)");
		
		pick.close();
	}
}