package hangMan;

import java.util.*;
import java.util.Random;

public class PolicalWordGuess {
	static String wordList[] = { "GOVERNMENT", "POLITICO", "LEGISLATURE", "DEMOCRATIC", "REPUBLICAN", "SENATE",
			"BIPARTISAN", "REPUBLICAN", "LIBERTY", "REPRESENTATION" };
	static int cashPrize[] = { 10, 15, 20, 25, 30 }; //changing the type ti int array so it will be easy to work with

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		String wordToBeGuessed = wordList[random.nextInt(wordList.length)];

		char choice;
		do {
			// take user input for mode of game
			System.out.print("Welcome to Policital Hangman Game." + "\n\nHow would you like to play the game?"
					+ "\nA.Try to guess whole word. (cash prize = $0)"
					+ "\nB.Try to quess word letter-by-letter. (lot of cash prize!!)" + "\nEnter (A or B): ");

			choice = scanner.next().toUpperCase().charAt(0); // store user input into choice as a upper case letter
			if ("AB".contains("" + choice))
				break;
			else
				System.out.println("\nEnter A or B only!!\n");
		} while (true); //take input until its not A or B.
		
		//show the star word:
		
		if (choice=='A') {
			System.out.println("\nWord: " + wordToBeGuessed.replaceAll("[A-Za-z0-9]", "*"));
			int numTry = 1;
			do {
			System.out.print("Enter the word (try"+ numTry +"/3): ");
			String guessedWord = scanner.next();
			
			if (guessedWord.compareToIgnoreCase(wordToBeGuessed)==0) {
				System.out.println("You Won!! "+wordToBeGuessed+" is the correct word!");
				break;
			} else {
				System.out.print("Wrong Guess");
				if(numTry==3) System.out.println(", GAME OVER! \nThe correct word was "+wordToBeGuessed);
				else System.out.println(", Try again!");
			}
			numTry++;
			} while (numTry<=3);
		} else {
			ArrayList<Character> guessedChars = new ArrayList<>(); //this will store the already guessed chars, used in mode B.
			int wrongGuess = 0; //stores the number of wrong guesses
			int prize = 0;
			do {
			String starWord = "";
			//replace all characters of wordToBeGuessed with *, unless character has already been guessed.
			int prizePerChar = cashPrize[random.nextInt(cashPrize.length)];
			for (int i = 0; i < wordToBeGuessed.length(); i++) {
				if (guessedChars.contains(wordToBeGuessed.charAt(i))) {
					starWord+=wordToBeGuessed.charAt(i);
					//also increase the prize money
					prize+=prizePerChar;
				} else {
					starWord+="*";
				}
			}
			
			if (!starWord.contains("*")) { //if star word do not contains "*"
				System.out.println("\nYes! "+wordToBeGuessed+" is the correct word!"
						+ "\nYou Won "+prize+"$."); /////////////////cash prize
				break;
			}
			
			//print the starWord:
			System.out.println("\nWord: "+starWord);
			//take char input
			System.out.print("Enter a character: ");
			char guessedChar = scanner.next().toUpperCase().charAt(0);
			guessedChars.add(guessedChar);
			
			if (!wordToBeGuessed.contains(""+guessedChar)) { //if word does not contains the guessed char
				wrongGuess++;
			}
			
			if (wrongGuess>=3) {
				System.out.println("GAME OVER! \nThe correct word was "+wordToBeGuessed
						+ "\nYou won 0$");
			}
		}while(wrongGuess<3);
			
		}
		
		
		
		
		
		
		
		

		scanner.close();

	}

}