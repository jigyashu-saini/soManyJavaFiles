package q2;

import java.util.Random;

public class CoinToss {

	private String sideUp;// Hiding code from other classes

	public void toss() {

		// Creates random number
		Random random = new Random();
		int randomNumber;

		randomNumber = random.nextInt(2); // 0 to 1
		if (randomNumber == 1) {
			sideUp = " Heads ";
		} // End of if loop
		else if (randomNumber == 0) {
			sideUp = " Tails ";
		}

	}// End of toss method

	public String getSideUp() {
		return sideUp;

	}

	public CoinToss() {
		toss();
	}// End of constructor

}// End of CoinToss Class
