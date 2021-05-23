package p2005_0135;

import java.util.Scanner;

public class Series extends Show {
	private int numOfEpisodes;
	private int episodeDuration;

	public Series() {
		super();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the numOfEpisodes: ");
		this.numOfEpisodes = scanner.nextInt();
		System.out.print("Please enter the episodesDuration: ");
		this.episodeDuration = scanner.nextInt();
	}

	public Series(String name, int numOfEpisodes, int episodeDuration) {
		super(name);
		this.numOfEpisodes = numOfEpisodes;
		this.episodeDuration = episodeDuration;
	}

	public int getNumOfEpisodes() {
		return numOfEpisodes;
	}

	public int getEpisodeDuration() {
		return episodeDuration;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + this.numOfEpisodes + "--" + this.episodeDuration;
	}

}
