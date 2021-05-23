package itaAllAboutRobots;

public class Graduate extends Student {
	private String thesisTitle;

	public Graduate(String name, int id, double age, String thesisTitle) {
		super(name, id, age);
		this.thesisTitle = thesisTitle;
	}

	public String getThesisTitle() {
		return thesisTitle;
	}

	public void setThesisTitle(String thesisTitle) {
		this.thesisTitle = thesisTitle;
	}
	
	
}
