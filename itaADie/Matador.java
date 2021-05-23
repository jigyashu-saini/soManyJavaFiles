package itaADie;

import java.util.Scanner;

public class Matador {
	public static void main(String[] args) {
		final int WIN_POINTS = 121;
		
		int playerScore = 0;
		
		int computerScore = 0;
		
		boolean playerTurn = true;
		Scanner scanner = new Scanner(System.in);
		
		while(playerScore<=WIN_POINTS && computerScore<=WIN_POINTS) {
			if (playerTurn) {
				
				System.out.println("Player's Turn");
				
				int choice = 0;
				do {
				System.out.print("Enter a number between 2 and 6 as your choice: ");
				choice = scanner.nextInt();
				}while(!(choice>=2 && choice<=6));
				
				Die die1 = new Die();
				Die die2 = new Die();
				
				die1.roll(); die2.roll();
				
				System.out.println("die1: "+die1.getValue()+"\tdie2: "+die2.getValue());
				
				//rules
				if (die1.getValue()==1 && die2.getValue()==1) {
					playerScore-=20;
					System.out.println("Both die got 1, player's scores decrease by 20: score: "+playerScore);
					playerTurn = false; //makes it computer turn
				} else if (die1.getValue()==1 || die2.getValue()==1) {
					System.out.println("A die got 1, nothing adds to score. score: "+playerScore);
					playerScore=playerScore; //no change to score
					playerTurn = false;
				} else {
					if (die1.getValue()==choice && die2.getValue()==choice) {
						System.out.println("Both die got "+die1.getValue()+" Player Won!!");
						break;
					} else if (die1.getValue()==choice || die2.getValue()==choice) {
						playerScore+=die1.getValue()+die2.getValue();
					} else {
						playerTurn = false;
					}
					playerScore+=die1.getValue()+die2.getValue();
					System.out.println("No die got 1, adding die sum "+ (die1.getValue()+die2.getValue()) +" to score. Score: "+playerScore);
				}
				
			} else {
				System.out.println("Computer Turn");
				int choice = (int) ((Math.random()*4)+2);
				
				Die die1 = new Die();
				Die die2 = new Die();
				
				die1.roll(); die2.roll();
				
				System.out.println("die1: "+die1.getValue()+"\tdie2: "+die2.getValue());

				
				//rules
				if (die1.getValue()==1 && die2.getValue()==1) {
					computerScore-=20;
					System.out.println("Both die got 1, Computer's scores decrease by 20: score: "+computerScore);
					playerTurn = true; //makes it player turn
				} else if (die1.getValue()==1 || die2.getValue()==1) {
					System.out.println("A die got 1, nothing adds to score. score: "+computerScore);
					computerScore=computerScore; // no change to score
					playerTurn = true;
				} else {
					if (die1.getValue()==choice && die2.getValue()==choice) {
						System.out.println("Both die got "+die1.getValue()+" Computer Won!!");
						break;
					} else if (die1.getValue()==choice || die2.getValue()==choice) {
						computerScore+=die1.getValue()+die2.getValue();
					} else {
						playerTurn = true;
					}
					computerScore+=die1.getValue()+die2.getValue();
					System.out.println("No die got 1, adding die sum"+ (die1.getValue()+die2.getValue()) +" to score. Score: "+computerScore);
				}
			}
			System.out.println();
		}
		scanner.close();
	}
}
















