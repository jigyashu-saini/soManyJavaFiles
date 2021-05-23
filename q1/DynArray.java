package q1;

public class DynArray {

	private double array[];
	private int size;
	private int nextIndex; // nextIndex works like count, that stores the number of elements currently the
							// array has

	// setting fields as per instructions
	public DynArray() {
		array = new double[1];
		size = 1;
		nextIndex = 0;
	}

	public int arraySize() {
		return size;
	}

	public int element() {
		return nextIndex;
	}

	public double at(int index) {
		if (0 <= index && index < nextIndex) {
			return array[index];
		}
		return Double.NaN; // Nan means not a number, you havve when u divide something by 0 for example.
	}

	private void grow() {
		double tempArray[] = new double[size * 2]; // create an temp array of double the size;
		System.arraycopy(array, 0, tempArray, 0, nextIndex); // copy from array index 0 into tempArray starting at
																	// index
																	// 0, nextindex number of elements
		array = tempArray;
		size = array.length; // changing the size attribute
	}

	private void shrink() {
		double tempArray[] = new double[size / 2]; // create an temp array of double the size;
		System.arraycopy(array, 0, tempArray, 0, nextIndex); // copy from array index 0 into tempArray starting at
																	// index
																	// 0, nextindex number of elements
		array = tempArray;
		size = array.length; // changing the size attribute
	}

	public void insertAt(int index, double value) {
		if (0 <= index && index <= nextIndex) { // if index is non negative
			if (nextIndex >= size) { // if new element and ond elements exceeds the size of Array, then grow the
				// array
				this.grow();
			}
			if (index == nextIndex) { //if need to add at last index
				this.array[nextIndex] = value;
				nextIndex++;
				return;
			}
			// finally add the element appropriately
			System.arraycopy(array, index, array, index + 1, nextIndex - index); // shift one index right
			array[index] = value;
			nextIndex++;
		} else {
			// ...do nothing
		}
	}

	public void insert(double value) {
		this.insertAt(nextIndex, value);
	}

	public double removeAt(int index) {
		if (0 <= index && index < nextIndex) { // if index is non negative
			double elementToReturn;
			if (index == nextIndex - 1) { // if last element is supposed to be removed
				elementToReturn = array[index];
				nextIndex--;
			} else {
				// in other cases
				elementToReturn = array[index];
				System.arraycopy(array, index + 1, array, index , nextIndex - index); // shift one index left, deleting the
				nextIndex--;
			}
			if (nextIndex <= size / 2) { // shrink if necessary
				this.shrink();
			}
			return elementToReturn;
		} else {
			return Double.NaN;
		}
	}

	public double remove() {
		return this.removeAt(nextIndex - 1);
	}

	public void printArray() {
		for (int i = 0; i < nextIndex; i++) {
			System.out.println(array[i]);
		}
	}
}
