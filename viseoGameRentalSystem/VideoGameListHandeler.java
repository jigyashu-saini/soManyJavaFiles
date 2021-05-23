package viseoGameRentalSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class VideoGameListHandeler {

	// a method to print the header
	private void printHeader() {
		System.out.printf("%-15s %-20s \n", "Sn", "name");
	}

	// a method that returns true if listOfVideoGame already contains a game with
	// same name and sn
	private boolean exactGameFound(ArrayList<VideoGame> listOfVideoGames, String name, String sn) {
		for (VideoGame videoGame : listOfVideoGames) {
			if (videoGame.getName() == name && videoGame.getSn() == sn) {
				return true;
			}
		}
		return false;
	}

	public void listAllVideoGames(ArrayList<VideoGame> listOfVideoGames) {
		System.out.println("List of video Games: ");
		this.printHeader();
		int serialNumber = 0;
		for (VideoGame videoGame : listOfVideoGames) {
			System.out.println(++serialNumber + " " + videoGame);
		}
	}

	public void addNewVideoGame(ArrayList<VideoGame> listOfVideoGames, String sn, String name) {
		if (listOfVideoGames.size() >= 10) {
			System.out.println("Failed to add the game: List Overflow");
			return;
		} else if (this.exactGameFound(listOfVideoGames, name, sn)) {
			System.out.println("Failed to add the game: Game already exists");
			return;
		}
		listOfVideoGames.add(new VideoGame(sn, name));
		System.out.println(
				listOfVideoGames.get(listOfVideoGames.size() - 1).getName() + " has been added to available titles!");
	}

	public void editVideoGameInformation(ArrayList<VideoGame> listOfVideoGames, int index, String sn, String name) {
		if (this.exactGameFound(listOfVideoGames, name, sn)) {
			System.out.println("Failed to add the game: Game already exists");
			return;
		} else if (index > listOfVideoGames.size() || index < 0) {
			System.out.println("Failed to add the game: index out of range");
			return;
		}
		listOfVideoGames.add(index, new VideoGame(sn, name));
		listOfVideoGames.remove(index - 1);
		System.out.println("Videp Game information is now up-to-date!");
	}

	public void serchForVideoGame(ArrayList<VideoGame> listOfVideoGames, String name) {
		System.out.println("Serch result for '" + name + "':");
		int serialNumber = 1;
		for (VideoGame videoGame : listOfVideoGames) {
			if (videoGame.getName().toUpperCase().contains(name.toUpperCase())) {
				System.out.println(serialNumber + " " + videoGame);
			}
			serialNumber++;
		}
	}

	public void checkOut(ArrayList<VideoGame> listOfVideoGames, int index) {
		if (!listOfVideoGames.get(index - 1).isAvailable()) {
			System.out.println("This game is not available for checkout.");
			return;
		} else if (index>listOfVideoGames.size() || index<0) {
			System.out.println("Please select a vailid index.");
			return;
		}
		listOfVideoGames.get(index - 1).setAvailable(false);
		System.out.println("Video Game now checked out");

	}

	public void checkIn(ArrayList<VideoGame> listOfVideoGames, int index) {
		if (listOfVideoGames.get(index - 1).isAvailable()) {
			System.out.println("This game is not available for checkin.");
			return;
		} else if (index>listOfVideoGames.size() || index<0) {
			System.out.println("Please select a vailid index.");
			return;
		}
		listOfVideoGames.get(index - 1).setAvailable(true);
		System.out.println("Video Game now checked in");
	}
}
