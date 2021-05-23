package itaAllAboutRobots;

public class Undergraduate extends Student {
	private String year;

	public Undergraduate(String name, int id, double age, String year) {
		super(name, id, age);
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}	
}
