package permutationAndCombination;

import java.math.BigInteger;

public class Main {
	public static void main(String[] args) {
		//it is basically a simple permutation and combination problem
		//for a 2x2 grid we have to:
		//travel 2 times right and 2 times right in every case. this makes total steps 4
		
		//now we can fill these 4 steps in: (4x3x2x1)/(2!x2!) ways.
		//					   factorial_of_(grid_size_doubled)/(grid_size_factorial * grid_size_factorial)
		
		//there are total n*2_factorial_ways to fill all steps,
		//and we divide by n_factorial cause stepsRight and stepDown are similar to (going right is similar to goint right again)
		
		//therefore
		
		int gridSize = 20;
		
		//as the numbers gona be huze in magnitude, we will use BigInteger instead of int long..
		BigInteger factorial = new BigInteger("1"); //it gona be a huuuuuuze number
		for (int i = 1; i <= gridSize*2; i++) { 
			factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
		}
		
		BigInteger factorialGrid = new BigInteger("1");
		for (int i = 1; i <= gridSize; i++) { 
			factorialGrid = factorialGrid.multiply(new BigInteger(String.valueOf(i)));
		}
		
		BigInteger resultantWays = factorial.divide(new BigInteger(String.valueOf(factorialGrid)));
		resultantWays = resultantWays.divide(new BigInteger(String.valueOf(factorialGrid)));
		
		System.out.println("For "+gridSize+"x"+gridSize+" grid total number of ways "
				+ "\nto go from left_top corner to Right_bottom corner are: "+resultantWays);
	}
}
