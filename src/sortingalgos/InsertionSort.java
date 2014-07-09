package sortingalgos;
/**
 * 
 * Iterates over the array
 * For each element, remove it from the array, check the value against all previous values and find the place where it belongs
 * If the value is larger, it leaves the element in place and moves to next element
 * If the value is smaller, it finds the correct position in the sorted list, and shifts all the larger values one step next to make a space, and inserts the element in the correct position
 *
 */
public class InsertionSort implements SortingAlgo {
	private final static String ALGO_NAME = "InsertionSort";
	private int[] numbers;

	public String getAlgoName() {
		return ALGO_NAME;
	}

	public InsertionSort(int[] numbers) {
		if (numbers == null || numbers.length == 0)
			throw new IllegalArgumentException("Empty array passed");
		this.numbers = numbers;
	}

	public int[] sort() {
		for (int i = 1; i < numbers.length; i++) {
			int valueToSort = numbers[i];
			// find the insertion location while moving all larger element up
			int j = i;
			while (j > 0 && numbers[j - 1] > valueToSort) {
				numbers[j] = numbers[j - 1];
				j--;
			}
			numbers[j] = valueToSort;
		}
		return numbers;
	}

}
