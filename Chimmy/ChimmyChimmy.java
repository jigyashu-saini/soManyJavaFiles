package Chimmy;

import java.math.BigDecimal;
import java.util.Iterator;

public class ChimmyChimmy {
	
	public static BigDecimal calculateRootPlusRoot(double variable, int count) {
		if (count >= 5000) {
			return new BigDecimal("0");
		} else {
			return new BigDecimal( Math.sqrt(variable + calculateRootPlusRoot(variable, ++count).doubleValue()) );
		}
	}

	public static void main(String[] args) {
		
		double variable = 7;
		BigDecimal value = calculateRootPlusRoot(variable, 1);
		
		System.out.print(value);
		
		for (int i = 0; i < 1000; i++) {
			
		}
		
	}

}
