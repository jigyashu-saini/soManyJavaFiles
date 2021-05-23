package itaADie;

public class Die {
	private int value = 1;

	public Die() {}
	
	public Die(int value) {
		super();
		if (value>=1 || value<=6) {
			this.value = value;			
		} else {
			System.err.println("Value of Die shall be between 1 and 6 includive.");
		}
	}
	
	public void roll() {
		this.value=(int) (Math.random()*5)+1;
	}
	
	public int getValue() {
		return value;
	}
}

