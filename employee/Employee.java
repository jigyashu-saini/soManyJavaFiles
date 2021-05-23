package employee;

public class Employee {
	//a
	private int id;
	private String firstName;
	private String lastName;
	private double salary;

	//b
	public Employee(int id, String firstName, String lastName, double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	//c
	protected double getSalary() {
		return salary;
	}
	protected void setSalary(double salary) {
		this.salary = salary;
	}
	protected int getId() {
		return id;
	}
	protected String getFirstName() {
		return firstName;
	}
	protected String getLastName() {
		return lastName;
	}
	

	//d
	public void raiseSalary(int percentIncrease) {
		this.salary+=(percentIncrease*this.salary)/100;
	}
	
	//e
	public void employeeDetails() {
		//using string formats to make it look nicer
		System.out.printf("%9s %s %s\n","Name:",firstName,lastName);
		System.out.printf("%9s %d\n","ID:",id);
		System.out.printf("%9s %.2f\n","Salary:",salary);
	}
}

//f
class TestEmployeeClass{
	public static void main(String[] args) {
		Employee employee = new Employee(1000, "Tom", "Hanks", 10500);
		employee.employeeDetails();
		
		System.out.println();
		
		employee.raiseSalary(10);
		employee.employeeDetails();
		
	}
}
















