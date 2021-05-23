package batteries;

public class Appliance {

	protected String applianceName;
	protected String applianceManufacturer;
	protected int yearBuilt, cost;

	public void setName(String userName) {
		applianceName = userName;
	}

	public String getName() {
		return applianceName;
	}

	public void setManufacturer(String userManufacturer) {
		applianceManufacturer = userManufacturer;
	}

	public String getManufacturer() {
		return applianceManufacturer;
	}

	public void setYearBuilt(int userYearBuilt) {
		yearBuilt = userYearBuilt;
	}

	public int getYearBuilt() {
		return yearBuilt;
	}

	public void setCost(int userCost) {
		cost = userCost;
	}

	public int getCost() {
		return cost;
	}

	public void printInfo() {
		System.out.println("Appliance Information: ");
		System.out.println(" Name: " + applianceName);
		System.out.println(" Manufacturer: " + applianceManufacturer);
		System.out.println(" Year built: " + yearBuilt);
		System.out.println(" Cost: " + cost);
	}

}
