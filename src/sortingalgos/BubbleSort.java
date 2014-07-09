package sortingalgos;
/**
 * Traverse the array from the beginning
 * Compare an element with the next element
 * Swap the two elements if the next element is smaller
 * After each iteration, one less element is compared (the last element is already sorted) until there are no more elements left 
 * 
 */
public class BubbleSort implements SortingAlgo {
	private final static String ALGO_NAME = "BubbleSort";
	private int[] numbers;

	public String getAlgoName() {
		return ALGO_NAME;
	}

	public BubbleSort(int[] numbers) {
		if (numbers == null || numbers.length == 0)
			throw new IllegalArgumentException("Empty array passed");
		this.numbers = numbers;
	};

	public int[] sort() {
		int n = numbers.length;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (numbers[j - 1] > numbers[j]) swap(j - 1, j);
			}
		}
		return numbers;
	}

	private void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
