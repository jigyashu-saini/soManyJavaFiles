package aStringComposed;

import java.util.HashMap;
import java.util.Map;

public class RedundantStrings {

	private static int howMany(int length) {
		HashMap<Integer, Integer> divisorAndValue = new HashMap<>();
		int totalWays = 0;
		for (int i = 1; i <= length / 2; i++) {
			if (length % i == 0) {
				int effectiveWays = (int) Math.pow(2, i);
				if (!divisorAndValue.isEmpty()) {
					for (Map.Entry<Integer, Integer> entry : divisorAndValue.entrySet()) {
						if (i % entry.getKey() == 0) {
							effectiveWays -= entry.getValue();
						}
					}
				}
				divisorAndValue.put(i, effectiveWays);
				totalWays += effectiveWays;
			}
		}
		return totalWays;
	}

	public static void main(String[] args) {
		System.out.println("For 0 length, total redundant string formations are: " + howMany(0));
		System.out.println("For 1 length, total redundant string formations are: " + howMany(1));
		System.out.println("For 2 length, total redundant string formations are: " + howMany(2));
		System.out.println("For 4 length, total redundant string formations are: " + howMany(4));
		System.out.println("For 10 length, total redundant string formations are: " + howMany(10));
		System.out.println("For 30 length, total redundant string formations are: " + howMany(30));
		System.out.println("For 60 length, total redundant string formations are: " + howMany(60));
	}

}
