package needHelpWith;

public class Runner {
	
	//using Number class so that it works with literally every type of number like integer float double etc...
	public static double increaseNum1ByNum2(Number num1, Number num2) {
		return num1.doubleValue() + num2.doubleValue();
	}
	
	//if you try to do it without using return statement like:
//	public static void increaseNum1ByNum2(Number num1, Number num2) {
//		num1 = num1.doubleValue() + num2.doubleValue();
//	}
	//that would not work, the value of num1 wont change
	//because parameters are passed by value in java
	//and hence when num1 is passed a value, some other memory location is assigned to it and original value 'numToChange' does not get affected
	
	public static void main(String[] args) {
		Number numToChange = 10;
		numToChange = increaseNum1ByNum2(numToChange, 2);
		System.out.println(numToChange);
	}
}
