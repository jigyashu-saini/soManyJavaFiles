package itaADie;

import java.util.Scanner;

public class Guess {
	public static void main(String[] args) {
		// two die
		Die die1 = new Die();
		Die die2 = new Die();

		// take user input
		Scanner scanner = new Scanner(System.in);
		int guess;
		do {
			System.out.print("Enter a guess(between 2 and 12): ");
			guess = scanner.nextInt();
		} while (!(guess <= 12 && guess >= 2));

		int i = 1;
		while (i != 4) { //runs 3 times
			die1.roll();
			die2.roll();
			System.out.println("Play " + i);
			System.out.println("die1: " + die1.getValue());
			System.out.println("die2: " + die2.getValue());
			System.out.println(" sum: " + (die1.getValue() + die2.getValue()));

			if (die1.getValue() + die2.getValue() == guess) {
				System.out.println("_You won!_");
				break;
			} else {
				System.out.println("\n");
			}

			i++;
		}

		if (i == 4) { //means if we played 3 times
			System.out.println("_Computer wins_");
		}

		scanner.close();
	}
}
