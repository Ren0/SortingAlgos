package sortingalgos;
/**
 * 
 * Divide the array into two partitions
 * Do that recursively on the two partitions to obtain n arrays of one element (sorted...)
 * Merge the n sub-arrays until there is only one array remaining  
 *
 */
public class MergeSort implements SortingAlgo {
	private final static String ALGO_NAME = "MergeSort";
	private int[] numbers;

	public String getAlgoName() {
		return ALGO_NAME;
	}

	public MergeSort(int[] numbers) {
		if (numbers == null || numbers.length == 0)
			throw new IllegalArgumentException("Empty array passed");
		this.numbers = numbers;
	}

	public int[] sort() {
		return mergeSort(numbers);
	}

	private int[] mergeSort(int[] numbers) {
		if (numbers.length <= 1) {
			return numbers;
		}

		// Split the array in half
		int[] first = new int[numbers.length / 2];
		int[] second = new int[numbers.length - first.length];
		System.arraycopy(numbers, 0, first, 0, first.length);
		System.arraycopy(numbers, first.length, second, 0, second.length);

		// Sort each half
		mergeSort(first);
		mergeSort(second);

		return merge(first, second, numbers);
	}

	public static int[] merge(int[] first, int[] second, int[] result) {
		int cursorFirst = 0, cursorSecond = 0, cursorResult = 0;

		// Runs until neither array is empty
		while (cursorFirst < first.length && cursorSecond < second.length) {
			// Compare the items of two arrays and copy the smaller item into to
			// third array
			if (first[cursorFirst] < second[cursorSecond]) {
				result[cursorResult++] = first[cursorFirst++];
			} else {
				result[cursorResult++] = second[cursorSecond++];
			}
		}

		// If array B's cursor scanned and compared all the items of the array
		// but array A's is not
		while (cursorFirst < first.length) {
			result[cursorResult++] = first[cursorFirst++];
		}

		// If array A's cursor scanned and compared all the items of the array
		// but array B's is not
		while (cursorSecond < second.length) {
			result[cursorResult++] = second[cursorSecond++];
		}

		return result;
	}

}
