package viseoGameRentalSystem;

// A class that represents a Video Game 
public class VideoGame {
	private String sn;
	private String name;
	private boolean available;
	
	public VideoGame(String sn, String name, boolean available) {
		super();
		this.sn = sn;
		this.name = name;
		this.available = available;
	}
	
	public VideoGame(String sn, String name) {
		this(sn, name, true); //call previous constructor with available=true
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return String.format("%-15s %-20s %s", sn, name, available?"Available":"Not Available");
	}
	
	
	
}
