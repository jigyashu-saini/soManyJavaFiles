package viseoGameRentalSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	public static int displayOptions(Scanner scanner) {
		int option;
		do {
			System.out.println("*************************************");
			System.out.println("Video Game rental information: \n");
			System.out.println("1. List video Game");
			System.out.println("2. Add new video Game");
			System.out.println("3. Edit video Game information");
			System.out.println("4. Serch by video Game");
			System.out.println("5. Check out video Game");
			System.out.println("6. Check in video Game");
			System.out.println("7. Exit");
			System.out.println();
			System.out.print("Select between 1-7: ");
			option = scanner.nextInt();
		} while (!(option < 7) && option < 0);
		scanner.nextLine();
		return option;
	}

	public static void callAddNewVideoGame(Scanner scanner, ArrayList<VideoGame> listOfVideoGames,
			VideoGameListHandeler handeler) {
		System.out.println("Enter information about new video game:");
		System.out.print("SN: ");
		String sn = scanner.next();
		scanner.nextLine(); // to digest the extra enter
		System.out.print("Game Title: ");
		String name = scanner.nextLine();
		// call the handeler to handel this modification
		handeler.addNewVideoGame(listOfVideoGames, sn, name);
	}

	public static void callEditVideoGameInformation(Scanner scanner, ArrayList<VideoGame> listOfVideoGames,
			VideoGameListHandeler handeler) {
		handeler.listAllVideoGames(listOfVideoGames);
		System.out.print("What video Game information would you like to edit?(1-" + listOfVideoGames.size() + "): ");
		int index = scanner.nextInt();
		System.out.print("SN: ");
		String sn = scanner.next();
		scanner.nextLine();
		System.out.print("Game Title: ");
		String name = scanner.nextLine();
		handeler.editVideoGameInformation(listOfVideoGames, index, sn, name);
	}

	public static void callSerchForVideoGame(Scanner scanner, ArrayList<VideoGame> listOfVideoGames,
			VideoGameListHandeler handeler) {
		System.out.print("Enter the name of game: ");
		String name = scanner.nextLine().strip();
		handeler.serchForVideoGame(listOfVideoGames, name);
	}

	public static void callCheckOut(Scanner scanner, ArrayList<VideoGame> listOfVideoGames,
			VideoGameListHandeler handeler) {
		int serialNumber = 1;
		for (VideoGame videoGame : listOfVideoGames) {
			if (videoGame.isAvailable()) {
				System.out.println(serialNumber + " " + videoGame);
			}
			serialNumber++;
		}
		System.out.printf("Entere the number of game you want to check out: ");
		int index = scanner.nextInt();
		scanner.nextLine();
		handeler.checkOut(listOfVideoGames, index);
	}

	public static void callCheckIn(Scanner scanner, ArrayList<VideoGame> listOfVideoGames,
			VideoGameListHandeler handeler) {
		int serialNumber = 1;
		for (VideoGame videoGame : listOfVideoGames) {
			if (!videoGame.isAvailable()) {
				System.out.println(serialNumber + " " + videoGame);
			}
			serialNumber++;
		}
		System.out.printf("Entere the number of game you want to check in: ");
		int index = scanner.nextInt();
		scanner.nextLine();
		handeler.checkIn(listOfVideoGames, index);
	}

	public static void pause(Scanner scanner) {
		System.out.println("Press enter to continue again");
		scanner.nextLine();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// an array List to store the games
		ArrayList<VideoGame> listOfVideoGames = new ArrayList<>();
		VideoGame v1 = new VideoGame("5531A", "Super Mario Bros.3");
		VideoGame v2 = new VideoGame("4432A", "Legend of Zelda", false);
		VideoGame v3 = new VideoGame("5546A", "Donkey Kong jr.");
		VideoGame v4 = new VideoGame("4353A", "Super Mario Kart", false);
		VideoGame v5 = new VideoGame("4556A", "Kid icarus", false);

		listOfVideoGames.add(v1);
		listOfVideoGames.add(v2);
		listOfVideoGames.add(v3);
		listOfVideoGames.add(v4);
		listOfVideoGames.add(v5);

		VideoGameListHandeler handeler = new VideoGameListHandeler();

		do {
			int choice = displayOptions(scanner);
			switch (choice) {
			case 1:
				handeler.listAllVideoGames(listOfVideoGames);
				break;
			case 2:
				callAddNewVideoGame(scanner, listOfVideoGames, handeler);
				break;
			case 3:
				callEditVideoGameInformation(scanner, listOfVideoGames, handeler);
				break;
			case 4:
				callSerchForVideoGame(scanner, listOfVideoGames, handeler);
				break;
			case 5:
				callCheckOut(scanner, listOfVideoGames, handeler);
				break;
			case 6:
				callCheckIn(scanner, listOfVideoGames, handeler);
				break;
			case 7:
				System.out.println("\n\n***THANKS FOR USING OUR PROGRAM***");
				scanner.close();
				System.exit(0);
			}
			pause(scanner);
		} while (true);
	}

}
