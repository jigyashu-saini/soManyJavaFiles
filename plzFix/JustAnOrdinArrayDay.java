package plzFix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class JustAnOrdinArrayDay {
	// private constructor so that object cannot be created
	private JustAnOrdinArrayDay() {
	}

	// determines if the sub-array starting at position start is a palindrome
	// returns true if palindrome is found
	public static boolean isPalindrome(int[] arr, int start) { // making the method public as required
		int end = arr.length - 1;
		while (start < end) {
			if (arr[start] != arr[end]) {
				return false;
			}
			++start;
			--end;
		}
		return true;
	}

	// returns an array consisting of the longest run of consecutive non-decreasing
	// values in the array
	static int[] longestAscending(int[] arr) {
		int longestAscendingRunLength = 1, currentAscendingRunLength = 1;
		
		int maxSequenceLength = 0;
		
		int tempArray1[] = arr;
		int tempArray2[] = null;
		
		for (int i = 1; i < arr.length-1; i++) {
			int tempIndex = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j]<arr[i]) {
					tempArray1[tempIndex]=arr[j];
					tempArray1[tempIndex+1]=arr[i];
					tempIndex++;
					for (int k = 0; k <= tempIndex; k++) {
						System.out.print(tempArray1[k]+" ");						
					}
					System.out.println();
				}
			}
			if (maxSequenceLength<tempIndex) {
				tempArray2 = new int[tempIndex+1];
				System.arraycopy(tempArray1, 0, tempArray2, 0, tempIndex+1);
				maxSequenceLength=tempIndex+1;
			}
		}
		return tempArray2;
		
		// startIndexLongest stores the position where the longest ascending sub-array
		// starts
//		int startIndexLongest = 0, startIndexCurrent = 0;
//		for (int i = 0; i < arr.length - 1; ++i) {
//			if (arr[i] <= arr[i + 1]) {
//				++currentAscendingRunLength;
//			} else {
//				if (currentAscendingRunLength > longestAscendingRunLength) {
//					startIndexLongest = startIndexCurrent;
//					longestAscendingRunLength = currentAscendingRunLength;
//				}
//				currentAscendingRunLength = 1;
//				startIndexCurrent = i + 1;
//				
//			}
//		}
//		// copy the longest ascending sub-array into an array and return
//		int[] longestAscendingRun = new int[longestAscendingRunLength];
//		System.arraycopy(arr, startIndexLongest, longestAscendingRun, 0, longestAscendingRunLength);
//		return longestAscendingRun;
	}

	// makes a palindrome from a given array
	// appends minimum possible number of elements
	static int[] makeIntoPalindrome(int[] arr) {
		
		if (arr.length==0) {
			return new int[0];
		}
		// find the smallest index start such that the sub-array arr[start..length-1] is
		// a palindrome
		int smallestIndex = -1;
		for (int i = 0; i < arr.length; ++i) {
			if (isPalindrome(arr, i)) {
				smallestIndex = i;
				break;
			}
		}
		// consider sub-array starting at index i is a palindrome
		// then, there are i elements before the sub-array
		// to make a palindrome, we need to insert these i elements at the right of the
		// sub-array
		int newArraySize = arr.length + smallestIndex;
		int[] palindromicArray = new int[newArraySize];
		// copy elements from the original array
		System.arraycopy(arr, 0, palindromicArray, 0, arr.length);
		// insert elements at the end to make it a palindrome
		for (int i = 0; i < smallestIndex; ++i) {
			palindromicArray[newArraySize - i - 1] = arr[i];
		}
		return palindromicArray;
	}

	// returns a new array with duplicates removed
	static java.lang.String[] removeMultiples(java.lang.String[] arr) {
		// arraylist to store unique elements
		ArrayList<java.lang.String> unique = new ArrayList<java.lang.String>();

		// traverse the array of strings
		for (java.lang.String s : arr) {
			boolean alreadyPresent = false;
			for (java.lang.String str : unique) {
				if (str.equals(s)) {
					// set flag to true if element has already been added
					alreadyPresent = true;
					break;
				}
			}
			// if string has not been already added
			// insert string to list
			if (!alreadyPresent) {
				unique.add(s);
			}
		}
		// convert arraylist back to array of String and return
		return unique.toArray(new String[0]);
	}

	// shifts the elements of the given array to the left by the given amount
	static void shiftLeft(int[] arr, int amount) {
		// if amount is >= size of array fill array with 0
		if (amount >= arr.length) {
			Arrays.fill(arr, 0);
		}
		// if amount < 0, it is equivalent to shiftRight(-amount)
		else if (amount < 0) {
			shiftRight(arr, -amount);
		} else {
			// shift to left
			for (int i = amount; i < arr.length; ++i) {
				arr[i - amount] = arr[i];
			}
			// fill remaining array with zeros
			for (int i = arr.length - amount; i < arr.length; ++i) {
				arr[i] = 0;
			}
		}
	}

	// shifts the elements of the given array to the right by the given amount
	static void shiftRight(int[] arr, int amount) {
		// if amount is >= size of array fill array with 0
		if (amount >= arr.length) {
			Arrays.fill(arr, 0);
		}
		// if amount < 0, it is equivalent to shiftLeft(-amount)
		else if (amount < 0) {
			shiftLeft(arr, -amount);
		} else {
			// shift to right
			for (int i = arr.length - 1; i >= amount; --i) {
				arr[i] = arr[i - amount];
			}
			// fill remaining array with zeros
			for (int i = amount - 1; i >= 0; --i) {
				arr[i] = 0;
			}
		}
	}

	// cycles the elements of the given array by given amount
	// rotates towards right if amount is positive, left if negative

	/*
	 * Consider an example, amount = 4, arr.length = 6
	 * 
	 * old_index | new_index 0 4 2 0 5 3
	 * 
	 * Observation: new_index = (old_index + amount) % (arr.length) For amount < 0,
	 * find a multiple (M) of arr.length such that (amount + M*arr.length) >= 0
	 */
	static void cycle(int[] arr, int amount) {
		// store the rotated array in a temporary array
		int[] rotatedArray = new int[arr.length];
		for (int i = 0; i < arr.length; ++i) {
			if (amount >= 0) {
				amount = amount % arr.length;
			} else {
				// find multiple M such that amount + M*arr.length >= 0
				// lets call M*arr.length as factor
				int factor = arr.length;
				while (amount + factor < 0) {
					factor += arr.length;
				}
				// update amount with the new value >= 0
				amount = amount + factor;
			}
			int newIndex = (i + amount) % arr.length;
			rotatedArray[newIndex] = arr[i];
		}
		// copy rotated array to original array
		System.arraycopy(rotatedArray, 0, arr, 0, arr.length);
	}

	// returns an array representing count of values falling into each specified
	// number of bins
	// bin is a subrange of values within (min, max)
	static int[] sortIntoBins(double[] data, int numBins, double min, double max) {
		// create an array of size numBins to store the count
		int[] arr = new int[numBins];
		// calculate the size of each bin
		// bin 0 has count of values in range [min, min + binSize)
		// bin 1 has count of values in range [min + binSize, min + 2*binSize)
		// so on
		double binSize = (max - min) / numBins;
		
		for (double v : data) {
			int index = (int) ((v - min) / binSize);
			if (index<=numBins && v>min) {
				arr[index]++;				
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[] = {5,3,7,10,9,11,13,10,14,16,17};
		System.out.println(Arrays.toString(longestAscending(arr)));
	}
}