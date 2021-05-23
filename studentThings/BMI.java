package studentThings;

import java.io.Serializable;
import java.text.DecimalFormat;

public class BMI implements Serializable{
	private int weight;
	private int height;
	private int option;
	private String firstName;
	private String lastName;

	/**
	 * Default constructor
	 * 
	 * @param weight
	 * @param height
	 * @param option
	 * @param firstName
	 * @param lastName
	 */
	public BMI() {
		this.weight = 70;
		this.height = 170;
		this.option = 1;
		this.firstName = "Default First Name";
		this.lastName = "Default Last Name";
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param weight
	 * @param height
	 * @param option
	 * @param firstName
	 * @param lastName
	 */
	public BMI(int weight, int height, int option, String firstName, String lastName) {
		this.weight = weight;
		this.height = height;
		this.option = option;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @param weight
	 */
	public void setWeight(int weight) {
		if (this.weight > 0) {
			this.weight = weight;
		}
	}

	/**
	 * @param height
	 */
	public void setHeight(int height) {
		if (this.height > 0) {
			this.height = height;
		}
	}

	/**
	 * @param option
	 */
	public void setOption(int option) {
		this.option = option;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		if (!this.firstName.equalsIgnoreCase("")) {
			this.firstName = firstName;
		}
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		if (!this.lastName.equalsIgnoreCase("")) {
			this.lastName = lastName;
		}
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the option
	 */
	public int getOption() {
		return option;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return BMI
	 */
	public double calcBMI() {
		if (option == 1) {
			double heightInMeter = (double) height / 100;
			return (double) weight / (double) (heightInMeter * heightInMeter);
		} else {
			return ((double) (weight * 703) / (double) (height * height));
		}

	}

	public String bmiString() {
		double bmi = calcBMI();
		// check range
		if (bmi < 18.5)
			return "Underweight";
		else if (bmi < 25)
			return "Normal";
		else if (bmi < 30)
			return "Overweight";
		else
			return "Obese";
	}

	@Override
	public String toString() {
		DecimalFormat df2 = new DecimalFormat("0.00");
		return "BMI is " + df2.format(calcBMI()) + " and is consider " + bmiString();
	}
}