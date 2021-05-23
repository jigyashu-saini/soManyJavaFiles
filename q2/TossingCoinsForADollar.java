package q2;

import java.util.ArrayList;
import java.util.Scanner;

public class TossingCoinsForADollar {
	public static void main(String[] args) {

		// get the players:
		Scanner scanner = new Scanner(System.in);
		int numOfPlayers;
		do {
			System.out.print("Enter the number of players: ");
			numOfPlayers = scanner.nextInt();
			if (numOfPlayers > 5 || numOfPlayers < 1) {
				System.out.println("Only 0 to 5 players are allowed.\n");
			} else {
				break;
			}
		} while (true);
		// an arrayList that will store all these players:
		ArrayList<Player> playerList = new ArrayList<>();

		// initialize all players
		for (int i = 0; i < numOfPlayers; i++) {
			System.out.print("Enter the name of player " + (i + 1) + ": ");
			playerList.add(new Player(scanner.next()));
		}

		System.out.println(); // gap, looks nice

		// initialize required coins
		CoinToss quarter = new CoinToss();
		CoinToss penny = new CoinToss();
		CoinToss dime = new CoinToss();
		CoinToss nickel = new CoinToss();

		int round = 0;
		boolean anyWin = false; // true if some player reaches 1 dolar or more, false otherwise
		Player winner = null; // will store the reference of Player who wins

		while (!anyWin) { // while there is no winn

			System.out.println("\n**********************************************");
			System.out.println("Round: " + (++round)); // Displays each round

			for (Player player : playerList) {

				quarter.toss();// calls toss method for quarter
				penny.toss();// calls toss method for penny
				dime.toss();// calls toss method for dime
				nickel.toss();// calls toss method for nickel

				if (penny.getSideUp() == " Heads " && player.getBalance()<1) { // if penny get heads add amount to balance
					player.setBalance(player.getBalance() + ((double) 1 / 100)); // Calculates amount of a penny
				} // End of if loop

				if (quarter.getSideUp() == " Heads " && player.getBalance()<1) { // if quarter get heads add amount to balance
					player.setBalance(player.getBalance() + ((double) 25 / 100));// Calculates amount of a quarter
				} // End of if loop

				if (dime.getSideUp() == " Heads " && player.getBalance()<1) { // if dime get heads add amount to balance
					player.setBalance(player.getBalance() + ((double) 10 / 100));// Calculates amount of a dime
				} // End of if loop

				if (nickel.getSideUp() == " Heads " && player.getBalance()<1) { // if nickel get heads add amount to balance
					player.setBalance(player.getBalance() + ((double) 5 / 100));// Calculates amount of a nickel
				} // End of if loop

				// print some info
				System.out.printf("%10s achieved a balane of: %.2f\n", player.getName(), player.getBalance());

				// dont toss coin and break while loop if someone wins
				if (player.getBalance() >= 1) {
					winner = player;
					anyWin = true;
					break;
				}
			} // end of fore loop
		} // End of while loop

		// someone will always win, print that
		System.out.printf("\n%s won!! with a balance of: %.2f", winner.getName(), winner.getBalance());

		scanner.close();
		
	}// End of main class

}// End of TossinfCoinsForADollar